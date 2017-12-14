package com.funbox.project.exception;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by zhao6 on 2017/12/8.
 */
public class BaseResponse  implements Serializable {

    @JSONField(name = "code")
    @JsonProperty("code")
    private String code;

    @JSONField(name = "message")
    @JsonProperty("message")
    private String message;

    @JSONField(name = "sub_cde")
    @JsonProperty("sub_code")
    private String subCode;

    @JSONField(name = "sub_message")
    @JsonProperty("sub_message")
    private String subMessage;

    @JSONField(name = "sign")
    @JsonProperty("sign")
    private String sign;

    public BaseResponse() {

    }

    public BaseResponse(String subCode, String subMessage) {
        this.subCode = subCode;
        this.subMessage = subMessage;
    }

    public BaseResponse(String code, String message, String subCode, String subMessage) {
        this.code = code;
        this.message = message;
        this.subCode = subCode;
        this.subMessage = subMessage;
    }

    public void appendSubMsg(String appendStr) {
        if (subMessage != null) {
            subMessage = subMessage + ": " + appendStr;
        } else {
            subMessage = appendStr;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
