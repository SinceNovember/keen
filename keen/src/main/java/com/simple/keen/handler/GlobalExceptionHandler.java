package com.simple.keen.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import com.simple.keen.common.base.Response;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;

/**
 * 全局异常处理
 *
 * @author SinceNovember
 * @date 2022/12/13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常
     */
    @ExceptionHandler(Throwable.class)
    public Response handleException(Throwable e) throws Throwable {
        // 如果异常为ServletException, 直接抛出, 不做处理. 只处理业务异常返回系统错误
        if (e instanceof ServletException) {
            throw e;
        } else if (e instanceof HttpMessageNotReadableException) {
            log.error("error: ", e);
            return Response.fail(MsgConsts.PARAMS_ERROR_CODE, MsgConsts.PARAMS_ERROR_MSG);
        } else {
            // 打印堆栈信息
            log.error("system error: ", e);
            return Response.fail(MsgConsts.SYSTEM_ERROR_CODE, MsgConsts.SYSTEM_ERROR_MSG);
        }
    }

    /**
     * 处理接口参数异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Response handleMethodArgumentNotValidException(Exception e) {
        try {
            String errorMsg;
            if (e instanceof MethodArgumentNotValidException) {
                errorMsg = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError()
                    .getDefaultMessage();
            } else {
                errorMsg = ((BindException) e).getBindingResult().getFieldError()
                    .getDefaultMessage();
            }

            log.error("参数异常: {}", errorMsg);
            return Response.fail(MsgConsts.PARAMS_ERROR_CODE, errorMsg);
        } catch (Exception ex) {
            log.error("system error: ", e);
            return Response.fail(MsgConsts.PARAMS_ERROR_CODE, MsgConsts.SYSTEM_ERROR_MSG);
        }
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(KeenException.class)
    public Response handleHyperException(KeenException e) {
        if (e.getCode() != null) {
            log.info("业务异常, code: {}, message: {}", e.getCode(), e.getMessage());
            return Response.fail(e.getCode(), e.getMessage());
        }
        if (StringUtils.isNotBlank(e.getMessage())) {
            log.info("业务异常: {}", e.getMessage(), e);
            return Response.fail(e.getMessage());
        } else {
            log.error("system error: ", e);
            return Response.fail(MsgConsts.SYSTEM_ERROR_MSG);
        }
    }

    @ExceptionHandler(NotLoginException.class)
    public Response notLoginException(NotLoginException e) {
        if (StringUtils.isNotBlank(e.getMessage())) {
            log.info("token异常, code: {}, message: {}", e.getCode(), e.getMessage());
            return Response.fail(HttpStatus.UNAUTHORIZED,
                StringUtils.subBefore(e.getMessage(), "：", true));
        } else {
            log.error("system error: ", e);
            return Response.fail(MsgConsts.SYSTEM_ERROR_MSG);
        }
    }

    @ExceptionHandler(SaTokenException.class)
    public Response saTokenException(SaTokenException e) {
        if (StringUtils.isNotBlank(e.getMessage())) {
            log.info("鉴权异常, code: {}, message: {}", e.getCode(), e.getMessage());
            return Response.fail(e.getMessage());
        } else {
            log.error("system error: ", e);
            return Response.fail(MsgConsts.SYSTEM_ERROR_MSG);
        }
    }
}
