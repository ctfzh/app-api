package com.funbox.project.service;

import com.funbox.project.core.Result;
import com.funbox.project.model.AppZfCache;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zhao6 on 2017/10/26.
 */
public interface WebChatOAuthService {
    /**
     * 生成用于获取access_token的Code的Url
     *
     * @param redirectUrl
     * @return
     */
    public String getRequestCodeUrl(String redirectUrl);

    /**
     * @Description: 发起微信支付
     * @param request
     */
    public Map<String, Object> wxPay(AppZfCache zfCache, HttpServletRequest request);


}
