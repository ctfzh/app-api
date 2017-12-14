package com.funbox.project.web;

import com.funbox.project.exception.PayException;
import com.funbox.project.exception.build.BaseExceptionBuild;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.service.AliPayService;
import com.funbox.project.service.WeiXinPayService;
import com.funbox.project.utils.PayUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by zhao6 on 2017/12/8.
 */
@RestController
@RequestMapping("/v4/one/yard")
public class OneYardPaymentController {
    private static org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(OneYardPaymentController.class);
    @Resource
    AliPayService aliPayService;

    @Resource
    private WeiXinPayService weiXinPayService;

    @RequestMapping(value = "/jumpUrl", method = RequestMethod.GET)
    public void jumpUrl(HttpServletRequest request, HttpServletResponse resp) {
        String url=request.getScheme()+"://"+ request.getServerName();//+request.getRequestURI();

        if(request.getServerPort()!=80){
            url = url+":"+request.getServerPort();
        }

        url = url+"/v4/one/yard/pay";

        if(StringUtils.isNotBlank(request.getQueryString())){
            url = url+"?"+request.getQueryString();
        }

        logger.info(url);

        weiXinPayService.encodeQrcode(url, resp);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public void pagePay(AppZfCache zfCache, HttpServletRequest request, HttpServletResponse resp) {
        String userAgent = request.getHeader("User-Agent");

        if (!userAgent.toLowerCase().contains("micromessenger") && !userAgent.toLowerCase().contains("alipayclient")) {
            throw new PayException(BaseExceptionBuild.buildData(BaseExceptionBuild.UNKNOWN_PATTYPE));
        }

        zfCache.setIp(PayUtil.getIp(request));

        String url = null;
        try {
            //微信支付
            if (userAgent.toLowerCase().contains("micromessenger")) {
                zfCache.setPayType(3);
                if (weiXinPayService.getCodeUrl(zfCache).getData() != null) {
                     url = weiXinPayService.getCodeUrl(zfCache).getData().toString();
                }

            }
            //支付宝支付
            if (userAgent.toLowerCase().contains("alipayclient")) {
                zfCache.setPayType(2);
                if (aliPayService.getCodeUrl(zfCache).getData() != null) {
                     url = aliPayService.getCodeUrl(zfCache).getData().toString();
                }

            }
            String redirect_uri = URLEncoder.encode(
                    url, "UTF-8");// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理（文档要求）
            // 按照文档要求拼接访问地址
            String url1 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                    + "wx0d4bb0e4ad001f29"
                    + "&redirect_uri="
                    + redirect_uri
                    + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
            resp.sendRedirect(url1);
        }catch (PayException e){
            throw new PayException(e.getCode(),e.getMessage(),"","");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
