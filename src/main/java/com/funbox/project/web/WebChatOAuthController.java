package com.funbox.project.web;

import com.funbox.project.bean.AutoWebParams;
import com.funbox.project.bean.SessionKey;
import com.funbox.project.bean.UserInfo;
import com.funbox.project.configurer.FunboxProperties;
import com.funbox.project.core.ProjectConstant;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.service.WebChatOAuthService;
import com.funbox.project.utils.HttpUtils;
import com.funbox.project.utils.PayUtil;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by zhao6 on 2017/10/26.
 */
@RestController
@RequestMapping("/v4/oauth")
public class WebChatOAuthController {
    @Resource
    private WebChatOAuthService webChatOAuthService;

    @Autowired
    FunboxProperties funboxProperties;

    /**
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/wxPay" , method = RequestMethod.POST)
    public Result getsessionkey(AppZfCache appZfCache,
                                HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        Map<String, Object> map = webChatOAuthService.wxPay(appZfCache, req);
        return ResultGenerator.genSuccessResult(map);
    }

    /**
     * @Description:微信支付回调
     * @return
     * @throws Exception
     */
    @PostMapping(value="/wxNotify")
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String userAgent = request.getHeader("User-Agent");
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
    }
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.println("接收到的报文：" + notityXml);

        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            if(PayUtil.verify(PayUtil.createLinkString(map), (String)map.get("sign"), funboxProperties.getKey(), "utf-8")){
                /**此处添加自己的业务逻辑代码start**/
//                webChatOAuthService.notifyLyVs();
                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    /**
     * 跳转到获取用户的信息的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/redirect")
    public void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String redirect_uri = "http://192.168.1.120:8080/oauth/getuserinfo";// 目标访问地址
        redirect_uri = URLEncoder.encode(
                "http://42.96.144.28/WeixinApiDemo/WeixinWebServlet", "UTF-8");// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理（文档要求）
        // 按照文档要求拼接访问地址
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                + "wx0d4bb0e4ad001f29"
                + "&redirect_uri="
                + redirect_uri
                + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        resp.sendRedirect(url);// 跳转到要访问的地址

    }

    /**
     * 小程序登陆接口
     * @param jscode
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/login")
    public Result getsessionkey(@RequestParam String jscode) throws UnsupportedEncodingException {
        // 拼接请求地址
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+funboxProperties.getAppid()+"&secret="
                +funboxProperties.getSecert()
                +"&js_code="+jscode+"&grant_type=authorization_code";

        String json = HttpUtils.getReturnJson(url, null);// 拿去返回值
        if(json.contains("errcode")){
            return ResultGenerator.genFailResult(json.toString());
        }else{
            SessionKey sessionKey = new SessionKey();
            Gson gson = new Gson();
            sessionKey = gson.fromJson(json, new SessionKey().getClass());
            return ResultGenerator.genSuccessResult(sessionKey);
        }
    }

    /**
     * 公众号获取用户信息
     * @param redirectUrl
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/getuserinfo")
    public Result getuserinfo(@RequestParam String redirectUrl) throws UnsupportedEncodingException {
        String code = webChatOAuthService.getRequestCodeUrl(redirectUrl);
        // 同意授权
        if (code != null) {
            // 拼接请求地址
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
                    + "appid=" + funboxProperties.getAppid() + "&secret="
                    +funboxProperties.getSecert()
                    + "&code=" + code
                    + "&grant_type=authorization_code";
            String json = HttpUtils.getReturnJson(url, null);// 拿去返回值
            AutoWebParams autoWebParams = new AutoWebParams();
            Gson gson = new Gson();
            autoWebParams = gson.fromJson(json, new AutoWebParams().getClass());

            /**
             * 第三步：刷新access_token（如果需要）
             */
            String url2 = "https://api.weixin.qq.com/sns/oauth2/refresh_token?"
                    + "appid=" + funboxProperties.getAppid()
                    + "&grant_type=refresh_token&refresh_token="
                    + autoWebParams.getRefresh_token();
            String json2 = HttpUtils.getReturnJson(url2, null);// 拿去返回值
            AutoWebParams autoWebParams2 = new AutoWebParams();
            Gson gson2 = new Gson();
            autoWebParams2 = gson2
                    .fromJson(json2, new AutoWebParams().getClass());

            /**
             * 第四步：拉取用户信息(需scope为 snsapi_userinfo)
             */
            String url3 = "https://api.weixin.qq.com/sns/userinfo?access_token="
                    + autoWebParams2.getAccess_token()
                    + "&openid="
                    + autoWebParams2.getOpenid() + "&lang=zh_CN";
            String json3 = HttpUtils.getReturnJson(url3, null);// 拿去返回值
            UserInfo userInfo = new UserInfo();
            Gson gson3 = new Gson();
            userInfo = gson3.fromJson(new String(json3.getBytes(), "utf-8"),
                    new UserInfo().getClass());
            System.out.println(userInfo);
            // -----------------------操作结束-------------------------
            return ResultGenerator.genSuccessResult(userInfo);
        }
        return ResultGenerator.genFailResult("未获取到用户信息");
    }
}
