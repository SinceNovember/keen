package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.simple.system.dao.UserMapper;
import com.simple.system.dao.UserTokenMapper;
import com.simple.system.model.entity.User;
import com.simple.system.model.entity.UserToken;
import com.simple.system.service.ShiroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private UserTokenMapper userTokenMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public UserToken getUserToken(String accessToken) {
        LambdaQueryWrapper<UserToken> lambdaQueryWrapper = Wrappers.lambdaQuery();;
        lambdaQueryWrapper.eq(UserToken::getToken, accessToken);
        UserToken userToken = userTokenMapper.selectOne(lambdaQueryWrapper);
        return userToken;
    }

    @Override
    public User getUser(Integer userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }
}
