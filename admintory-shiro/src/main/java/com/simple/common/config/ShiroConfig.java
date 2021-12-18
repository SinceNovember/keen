package com.simple.common.config;

import com.simple.common.annotation.ConditionalOnRedisUrl;
import com.simple.common.model.constant.PropertyConstant;
import com.simple.common.model.constant.Strings;
import com.simple.common.utils.StringUtils;
import com.simple.metadata.service.SystemConfigService;
import com.simple.system.oauth2.OAuth2Filter;
import com.simple.system.oauth2.OAuth2Realm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class ShiroConfig {

    @Autowired
    private  RedisProperties redisProperties;

    @Resource
    private SystemConfigService systemConfigService;


    @Bean("securityManager")
    public SecurityManager securityManager(OAuth2Realm oAuth2Realm, @Nullable RedisCacheManager redisCacheManager, DefaultWebSessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm);
        securityManager.setRememberMeManager(null);
        securityManager.setSessionManager(sessionManager);
        if (redisCacheManager != null) {
            securityManager.setCacheManager(redisCacheManager);
        }
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        //oauth过滤
        Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", new OAuth2Filter());
        shiroFilter.setFilters(filters);

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/app/**", "anon");
        filterMap.put("/api/system/login", "anon");
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/captcha.jpg", "anon");
        filterMap.put("/aaa.txt", "anon");
        filterMap.put("/**", "oauth2");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }


    /**
     * 配置Redis缓存
     * @return
     */
    @Bean
    @ConditionalOnRedisUrl
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisProperties.getHost() + Strings.COLON + redisProperties.getPort());
        if (StringUtils.isNotBlank(redisProperties.getPassword())) {
            redisManager.setPassword(redisProperties.getPassword());
        }
        redisManager.setTimeout(redisManager.getTimeout());
        redisManager.setDatabase(redisProperties.getDatabase());
        return redisManager;
    }

    @Bean
    @ConditionalOnBean(RedisManager.class)
    public RedisCacheManager redisCacheManager(RedisManager redisManager){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        // 权限缓存超时时间，和session超时时间一致
        redisCacheManager.setExpire(getExpireTime());
        redisCacheManager.setRedisManager(redisManager);
        redisCacheManager.setPrincipalIdFieldName("userId");
        return redisCacheManager;
    }

    @Bean
    @ConditionalOnBean(RedisManager.class)
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        redisSessionDAO.setExpire(getExpireTime());
        return redisSessionDAO;
    }


    @Bean
    @ConditionalOnMissingBean(RedisSessionDAO.class)
    public MemorySessionDAO sessionDAO(){
        return new MemorySessionDAO();
    }

    @Bean
    public DefaultWebSessionManager sessionManager(SessionDAO sessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置 session超时时间
        sessionManager.setGlobalSessionTimeout(86400);
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }



    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    private int getExpireTime(){
        return StringUtils.isNotBlank(systemConfigService.getConfigValueByConfigName("sessionExpireTime")) ? Integer.valueOf(systemConfigService.getConfigValueByConfigName("sessionExpireTime")) : PropertyConstant.SESSION_EXPIRE_TIME;
    }
    /**
     * 为了解决shiro无法通过@Autowired 注入属性的问题
     * @return
     */
    @Bean("lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }






}
