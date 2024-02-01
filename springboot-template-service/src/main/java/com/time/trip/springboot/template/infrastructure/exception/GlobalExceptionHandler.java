package com.time.trip.springboot.template.infrastructure.exception;

import com.time.trip.springboot.template.infrastructure.response.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public SingleResponse<?> handleBizError(BizException bizErrorException) {
        String errorCode = bizErrorException.errorCode();
        String errorMessage = bizErrorException.errorMessage();
        log.error(errorMessage);
        return SingleResponse.buildFailure(errorCode, errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public SingleResponse<?> handleError(Exception ex) {
        log.error("Exception: ", ex);
        return SingleResponse.buildFailure(BizExceptionEnum.SYSTEM_ERROR.errorCode(), BizExceptionEnum.SYSTEM_ERROR.errorMessage());
    }

}

