package com.simple.common.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 实体AOP，用于在保存实体前赋值如创建日期等
 */
//@Aspect
//@Component
public class EntityAspectHandler {

    @Pointcut("execution(* com.simple.system.service.*.save*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint ) {
        Map<String, Class<?>> params = new HashMap<>();
        params.put("setUpdateTime", Date.class);
        params.put("setCreateTime", Date.class);
        setClassValue(joinPoint.getArgs()[0],params);

    }

    public void setClassValue(Object object,Map<String, Class<?>> params) {

        Class<?> clazz = object.getClass().getSuperclass();
        if (clazz != null) {
                params.entrySet().stream()
                        .forEach(entry ->invokeMethod(entry,object,clazz));

        }
    }

    private void invokeMethod(Map.Entry<String,Class<?>> entry, Object object, Class<?> clazz) {
        try {
            Method method = clazz.getMethod(entry.getKey(), entry.getValue());
            method.invoke(object, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
