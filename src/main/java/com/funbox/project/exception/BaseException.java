package com.funbox.project.exception;

/**
 * Created by zhao6 on 2017/12/8.
 */
public class BaseException extends RuntimeException{
    private String code;

    private String message;

    private String subCode;

    private String subMessage;


    public BaseException(String code, String message, String subCode, String subMessage) {
        this.code = code;
        this.message = message;
        this.subCode = subCode;
        this.subMessage = subMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
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


}
