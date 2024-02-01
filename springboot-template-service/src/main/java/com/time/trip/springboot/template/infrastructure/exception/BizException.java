package com.time.trip.springboot.template.infrastructure.exception;

public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    public BizException(BizExceptionEnum bizExceptionMessageEnum) {
        this.errorCode = bizExceptionMessageEnum.errorCode();
        this.errorMessage = bizExceptionMessageEnum.errorMessage();
    }

    public BizException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
