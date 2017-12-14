package com.funbox.project.web;

import com.alipay.api.internal.util.AlipaySignature;
import com.funbox.project.configurer.FunboxProperties;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.service.AliPayService;
import com.funbox.project.service.WeiXinPayService;
import com.funbox.project.utils.AlipayConfig;
import com.funbox.project.utils.redis.RedisClientTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by zhao6 on 2017/11/13.
 */
@RestController
@RequestMapping("/v4/ali")
public class AliPayController {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(WeiXinPayController.class);
    @Resource
    AliPayService aliPayService;

    @Resource
    private WeiXinPayService weiXinPayService;

    @Autowired
    FunboxProperties funboxProperties;

    @Autowired
    RedisClientTemplate redisClientTemplate;

    // 扫码支付
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public void pagePay(AppZfCache zfCache, HttpServletResponse resp) throws Exception {
        if (aliPayService.getCodeUrl(zfCache).getData() != null) {
            String url = aliPayService.getCodeUrl(zfCache).getData().toString();
            aliPayService.encodeQrcode(url, resp);
        }
    }

    /**
     * 支付宝支付之后的回调方法
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    public void wechatNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String> map = toMap(request);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                logger.info(entry.getKey() + " = " + entry.getValue());
            }

            boolean flag = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET,
                    AlipayConfig.SIGNTYPE);
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            if (flag) {
                logger.info("precreate_notify_url success");
                if ("TRADE_SUCCESS".equals(map.get("trade_status"))) {
                    weiXinPayService.notifyLyVs(map.get("out_trade_no"));
                }
                out.write("success".getBytes());
                out.flush();
                out.close();
            } else {
                logger.info("precreate_notify_url failure");
                out.write("failure".getBytes());
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 将异步通知的参数转化为Map
     *
     * @param request
     * @return
     */
    private static Map<String, String> toMap(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        return params;
    }
}
