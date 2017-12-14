package com.funbox.project.exception;

/**
 * Created by zhao6 on 2017/12/8.
 */
public class PayException extends BaseException{
    private BaseResponse baseResponse;

    public PayException(String code, String message, String subCode, String subMessage) {
        super(code, message, subCode, subMessage);
    }

    public PayException(BaseResponse baseResponse) {
        super(baseResponse.getCode(),baseResponse.getMessage(),baseResponse.getSubCode(),baseResponse.getSubMessage());
        this.baseResponse=baseResponse;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }
}
