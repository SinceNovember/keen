package com.simple.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.simple.common.exception.AdmintoryException;
import com.simple.common.model.constant.PropertyConstant;
import com.simple.common.utils.RedisUtils;
import com.simple.common.utils.StringUtils;
import com.simple.metadata.service.SystemConfigService;
import com.simple.monitor.model.entity.ActiveUser;
import com.simple.system.dao.UserTokenMapper;
import com.simple.system.model.dto.UserDTO;
import com.simple.system.model.entity.UserToken;
import com.simple.system.oauth2.TokenGenerator;
import com.simple.system.service.UserService;
import com.simple.system.service.UserTokenService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.ExpiredCredentialsException;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static com.simple.common.utils.StringUtils.keyGenerate;
import static com.simple.common.utils.StringUtils.relateKeyGenerate;

/**
 * Redis的Token生成器
 */
@Slf4j
public class RedisUserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private UserService userService;

    @Resource
    private SystemConfigService systemConfigService;


    @Override
    public Map<String, Object> createToken(Integer userId) {
        //生成一个Token
        String token = TokenGenerator.generateValue();
        redisUtils.set(keyGenerate(token), userId, getExpireTime());
        return ImmutableMap.of("token", token, "expire", getExpireTime());
    }

    @Override
    public void createTokenSessionRelate(@NonNull String token, @NonNull String session) {
        redisUtils.set(relateKeyGenerate(session), token, getExpireTime());
    }

    @Override
    public Integer verityUserToken(String accessToken) {
        Object val = redisUtils.get(keyGenerate(accessToken));
        if (Objects.isNull(val)) {
            throw new ExpiredCredentialsException("token失效， 请重新登陆");
        }
        //验证成功后，重置token的缓存时间
        redisUtils.expire(keyGenerate(accessToken), getExpireTime());
        return Integer.valueOf(val.toString());
    }

    @Override
    public UserDTO getUserByToken(String token) {
        Integer userId = verityUserToken(token);
        return userService.getUserDetailById(userId);
    }

    @Override
    public void clearToken(ActiveUser activeUser, String token) {
        if (StringUtils.isBlank(token)) {
            token = Optional.of(redisUtils.get(StringUtils.relateKeyGenerate(activeUser.getId()))).orElseThrow(() -> new AdmintoryException("缓存中无对应关系")).toString();
        }
        removeToken(token);
        removeTokenSessionRelate(activeUser.getId());
    }

    private void removeToken(String token) {
        String keyToken = keyGenerate(token);
        redisUtils.del(keyToken);

    }

    /**
     *  删除session-token关系
     * @param session
     */
    private void removeTokenSessionRelate(String session) {
        String relate = relateKeyGenerate(session);
        redisUtils.del(relate);
    }

    /**
     * 系统关闭时，清除redis中得登陆信息
     */

    @PreDestroy
    private void redisShutdownHook(){
        log.info("clear redis login info");
        Set<String> keys = redisUtils.keys("shiro:" + "*");
        redisUtils.del(keys);
    }

    private int getExpireTime(){
        return StringUtils.isNotBlank(systemConfigService.getConfigValueByConfigName("sessionExpireTime")) ? Integer.valueOf(systemConfigService.getConfigValueByConfigName("sessionExpireTime")) : PropertyConstant.SESSION_EXPIRE_TIME;
    }

}
