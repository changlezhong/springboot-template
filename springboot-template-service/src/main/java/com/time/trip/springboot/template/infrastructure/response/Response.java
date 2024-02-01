package com.time.trip.springboot.template.infrastructure.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class Response extends DTO {

    private static final long serialVersionUID = 1L;
    @Schema(description = "是否成功")
    private boolean success;
    @Schema(description = "错误编码")
    private String errCode;
    @Schema(description = "错误信息")
    private String errMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }


    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }


    public String getErrMessage() {
        return errMessage;
    }


    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }


    @Override
    public String toString() {
        return "Response [success=" + success + ", errCode=" + errCode + ", errMessage=" + errMessage + "]";
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static Response buildSuccess(){
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

}
