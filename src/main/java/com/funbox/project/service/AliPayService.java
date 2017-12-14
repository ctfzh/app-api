package com.funbox.project.service;

import com.funbox.project.core.Result;
import com.funbox.project.model.AppZfCache;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhao6 on 2017/11/10.
 */
public interface AliPayService {
    Result getCodeUrl(AppZfCache zfCache);

    void encodeQrcode(String content, HttpServletResponse response);

//    void notifyLyVs(String orderId);
}
