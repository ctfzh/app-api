package com.funbox.project.service.impl;

import com.funbox.project.configurer.FunboxProperties;
import com.funbox.project.core.ProjectConstant;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.service.AppZfCacheService;
import com.funbox.project.service.WebChatOAuthService;
import com.funbox.project.utils.PayUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhao6 on 2017/10/26.
 */
@Service
public class WebChatOAuthServiceImpl implements WebChatOAuthService{
    @Resource
    private AppZfCacheService zfCacheService;

    @Autowired
    FunboxProperties funboxProperties;


    @Override
    public String getRequestCodeUrl(String redirectUrl) {
        return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
                funboxProperties.getAppid(), redirectUrl, "snsapi_userinfo", "xxxx_state");
    }

    /**
     * @Description: 发起微信支付
     * @param request
     */
    @Override
    public Map<String, Object>  wxPay(AppZfCache zfCache, HttpServletRequest request){
        try{
            //生成的随机字符串
            String nonce_str = getRandomStringByLength(32);
            //商品名称
            String body = zfCache.getMdseName();
            //获取客户端的ip地址
            String spbill_create_ip = PayUtil.getIp(request);

            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", funboxProperties.getAppid());
            packageParams.put("mch_id", funboxProperties.getMch_id());
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            packageParams.put("out_trade_no", nonce_str);//商户订单号
            packageParams.put("total_fee", "1");//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", funboxProperties.getNotify_url());//支付成功后的回调地址
            packageParams.put("trade_type", funboxProperties.getTradetype());//支付方式
            packageParams.put("openid", zfCache.getOpenid());

            String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = PayUtil.sign(prestr,funboxProperties.getKey(), "utf-8").toUpperCase();

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + funboxProperties.getAppid() + "</appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id>" + funboxProperties.getMch_id() + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + funboxProperties.getNotify_url() + "</notify_url>"
                    + "<openid>" + zfCache.getOpenid() + "</openid>"    // order
                    + "<out_trade_no>" + nonce_str + "</out_trade_no>"  // order
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
                    + "<total_fee>" + "1" + "</total_fee>"   // order
                    + "<trade_type>" + funboxProperties.getTradetype() + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";

            System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

            //调用统一下单接口，并接受返回的结果
            String result = PayUtil.httpRequest(funboxProperties.getPay_url(), "POST", xml);

            System.out.println("调试模式_统一下单接口 返回XML数据：" + result);

            // 将解析结果存储在HashMap中
            Map map = PayUtil.doXMLParse(result);

            String return_code = (String) map.get("return_code");//返回状态码

            Map<String, Object> response = new HashMap<String, Object>();//返回给小程序端需要的参数
            if(return_code=="SUCCESS"||return_code.equals(return_code)){
                zfCache.setOutTradeNo(nonce_str);
                zfCacheService.save(zfCache);

                //添加h5订单
//                wxAddOrder(zfCache, request.getHeader("User-Agent"));

                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                response.put("nonceStr", nonce_str);
                response.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + funboxProperties.getAppid() + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtil.sign(stringSignTemp, funboxProperties.getKey() , "utf-8").toUpperCase();

                response.put("paySign", paySign);
            }

            response.put("appid", funboxProperties.getAppid());

            return response;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * StringUtils工具类方法
     * 获取一定长度的随机字符串，范围0-9，a-z
     * @param length：指定字符串长度
     * @return 一定长度的随机字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }



}
