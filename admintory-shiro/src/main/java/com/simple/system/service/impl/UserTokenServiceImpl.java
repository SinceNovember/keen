package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.simple.common.exception.AdmintoryException;
import com.simple.monitor.model.entity.ActiveUser;
import com.simple.system.dao.DeptMapper;
import com.simple.system.dao.UserMapper;
import com.simple.system.dao.UserTokenMapper;
import com.simple.system.model.dto.UserDTO;
import com.simple.system.model.entity.UserToken;
import com.simple.system.oauth2.TokenGenerator;
import com.simple.system.service.ShiroService;
import com.simple.system.service.UserTokenService;
import org.apache.shiro.authc.ExpiredCredentialsException;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private ShiroService shiroService;

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public Map<String, Object> createToken(Integer userId) {

        //生成一个Token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成token
        UserToken userToken = this.getById(userId);
        if (userToken == null) {
            userToken = new UserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            this.save(userToken);
        } else {
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            this.updateById(userToken);
        }
        return ImmutableMap.of("token", token, "expire", EXPIRE);
    }

    @Override
    public Integer verityUserToken(String accessToken) {

        LambdaQueryWrapper<UserToken> lambdaQueryWrapper = Wrappers.lambdaQuery();;
        lambdaQueryWrapper.eq(UserToken::getToken, accessToken);
        UserToken userToken = this.getOne(lambdaQueryWrapper);
        if (userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new ExpiredCredentialsException("token失效， 请重新登陆");
        }
        return userToken.getUserId();
    }

    @Override
    public UserDTO getUserByToken(String token) {
        return Optional.of(userMapper.getUserByToken(token)).map(user -> {
            String deptName = deptMapper.getDeptNameById(user.getDeptId());
            user.setDeptName(Optional.ofNullable(deptName).orElse(""));
            return user;
        }).orElseThrow(() -> new AdmintoryException("token获取用户失败"));
    }

    @Override
    public void clearToken(ActiveUser activeUser, String token) {
        //生成一个token
        String newToken = TokenGenerator.generateValue();
        //修改token
        UserToken userToken = new UserToken();
        userToken.setUserId(activeUser.getUserId());
        userToken.setToken(newToken);
        this.updateById(userToken);
    }
}
