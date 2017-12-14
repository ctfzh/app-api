package com.funbox.project.exception.build;

import com.funbox.project.exception.BaseException;
import com.funbox.project.exception.BaseResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhao6 on 2017/12/8.
 */
public class BaseExceptionBuild {
    private static Map<String, BaseResponse> MESSAGES = new HashMap<>();

    public static final String UNKNOWN_PATTYPE = "UNKNOWN-PATTYPE-ERROR";
    public static final String PRODUCTS_SOLD_OUT_ERROR = "PRODUCTS-SOLD-OUT-ERROR";
    public static final String WRONG_PRODUCT_PRICE_ERROR = "WRONG-PRODUCT-PRICE-ERROR";

    static {
        MESSAGES.put(UNKNOWN_PATTYPE, new BaseResponse("100001", "支付类型错误，不是支付宝或者微信支付", null, null));
        MESSAGES.put(PRODUCTS_SOLD_OUT_ERROR, new BaseResponse("100001", "products all sold out", null, null));
        MESSAGES.put(WRONG_PRODUCT_PRICE_ERROR, new BaseResponse("100001", "wrong product price", null, null));
    }

    public static BaseResponse buildData(BaseException ex) {
        return buildData(ex.getSubCode(), null);
    }

    public static BaseResponse buildData(String errorCode) {
        return buildData(errorCode, null);
    }

    public static BaseResponse buildData(String errorCode, String errorMsg) {
        BaseResponse baseResponse =  MESSAGES.get(errorCode);
        if (errorMsg != null && !"".equals(errorMsg)) {
            baseResponse.setSubMessage(errorMsg);
        }
        return baseResponse;
    }

    public static BaseResponse buildData(String errorCode, String errorMsg, String errorSubMsg) {
        BaseResponse baseResponse =  MESSAGES.get(errorCode);
        baseResponse.setMessage(errorMsg);
        baseResponse.setSubMessage(errorSubMsg);
        return baseResponse;
    }
}
