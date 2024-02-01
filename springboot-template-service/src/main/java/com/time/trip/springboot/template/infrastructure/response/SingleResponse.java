package com.time.trip.springboot.template.infrastructure.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class SingleResponse<T> extends Response {
    @Schema(description = "数据")
    private T data;

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> singleResponse = new SingleResponse<>();
        singleResponse.setSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse<?> buildFailure(String errCode, String errMessage) {
        SingleResponse<?> response = new SingleResponse<>();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static SingleResponse<?> buildSuccess() {
        SingleResponse<?> response = new SingleResponse<>();
        response.setSuccess(true);
        return response;
    }

}
