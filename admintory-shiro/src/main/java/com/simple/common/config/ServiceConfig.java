package com.simple.common.config;

import com.simple.common.annotation.ConditionalOnRedisUrl;
import com.simple.system.service.UserTokenService;
import com.simple.system.service.impl.RedisUserTokenServiceImpl;
import com.simple.system.service.impl.UserTokenServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    @ConditionalOnRedisUrl
    public UserTokenService redisUserTokenService(){
        return new RedisUserTokenServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(UserTokenService.class)
    public UserTokenService userTokenService(){
        return new UserTokenServiceImpl();
    }

}
