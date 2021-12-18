package com.simple.common.handler;

import com.simple.common.exception.AdmintoryException;
import com.simple.common.model.entity.ResponseData;
import com.simple.common.model.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AdmintoryException.class)
    public ResponseData handleException(AdmintoryException e) {
        log.error("api请求操作异常", e.getCause());
        return Response.fail(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseData handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return Response.fail("系统内部异常");
    }

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public ResponseData handleException(IncorrectCredentialsException e) {
        log.error("系统内部异常，异常信息", e);
        return Response.fail("系统内部异常");
    }

}
