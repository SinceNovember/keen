package com.simple.common.aspect;

import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.exception.AdmintoryException;
import com.simple.common.utils.StringUtils;
import com.simple.monitor.service.OperationLogService;
import com.simple.system.model.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 调用方式切入,主要用户统计日志，统一异常
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class ControllerEndpointAspect extends BaseAspectSupport{

    @Resource
    private OperationLogService operationLogService;

    @Pointcut("@annotation(com.simple.common.annotation.ControllerEndpoint)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws AdmintoryException {
        Object result;
        Method targetMethod = resolveMethod(point);
        ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
        String operation = annotation.operation();
        long start = System.currentTimeMillis();
        try {
            result = point.proceed();
            if (StringUtils.isNotBlank(operation)) {
                RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
                String ip = StringUtils.EMPTY;
                if (servletRequestAttributes != null) {
                    ip = servletRequestAttributes.getRequest().getRemoteAddr();
                }
                // 设置操作用户
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                operationLogService.saveOperationLog(user, point, targetMethod, ip, operation, start);
            }
            return result;
        } catch (Throwable throwable) {
//            log.error(throwable.getMessage(), throwable);
            String exceptionMessage = annotation.exceptionMessage();
            String message = throwable.getMessage();
            String error = StringUtils.containChinese(message) ? exceptionMessage + "，" + message : exceptionMessage;
            throw new AdmintoryException(error, throwable);
        }
    }
}
