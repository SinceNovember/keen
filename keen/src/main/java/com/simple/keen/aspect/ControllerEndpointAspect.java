package com.simple.keen.aspect;

import cn.dev33.satoken.stp.StpUtil;
import com.simple.keen.common.annotation.ControllerEndpoint;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.HttpUtils;
import com.simple.keen.common.utils.StringUtils;
import com.simple.keen.monitor.service.IOperateLogService;
import com.simple.keen.system.service.IUserService;
import java.lang.reflect.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 调用方式切入,主要用户统计日志，统一异常
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class ControllerEndpointAspect extends BaseAspectSupport {

    private final IUserService userService;

    private final IOperateLogService operateLogService;

    @Pointcut("@annotation(com.simple.keen.common.annotation.ControllerEndpoint)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result;
        Method targetMethod = resolveMethod(point);
        ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
        String operation = annotation.operation();
        long start = System.currentTimeMillis();
        try {
            result = point.proceed();
            if (StringUtils.isNotBlank(operation)) {
                // 设置操作用户
                operateLogService.addOperateLog(
                    userService.getById(StpUtil.getLoginIdAsInt()).getNickname(), point,
                    targetMethod, HttpUtils.requestIp(), operation,
                    start);
            }
            return result;
        } catch (Throwable throwable) {
            throw new KeenException(
                annotation.exceptionMessage() + "，" + throwable.getMessage());
        }
    }

}
