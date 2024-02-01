package com.time.trip.springboot.template.infrastructure.exception;

/**
 * @author changlezhong
 * @description
 */
public enum BizExceptionEnum {

    SYSTEM_ERROR("-2", "系统异常"),

    ;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    BizExceptionEnum(String errorCode, String errorMessage) {
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
