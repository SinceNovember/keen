package com.simple.common.annotation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnExpression("#{!T(org.springframework.util.StringUtils).isEmpty('${spring.redis.host}')}")
public @interface ConditionalOnRedisUrl {
}
