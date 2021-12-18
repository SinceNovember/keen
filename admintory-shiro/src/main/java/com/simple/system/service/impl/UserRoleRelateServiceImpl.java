package com.simple.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.simple.system.dao.UserRoleRelateMapper;
import com.simple.system.model.entity.UserRoleRelate;
import com.simple.system.service.UserRoleRelateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserRoleRelateServiceImpl  extends ServiceImpl<UserRoleRelateMapper, UserRoleRelate> implements UserRoleRelateService {

    @Resource
    private UserRoleRelateMapper userRoleRelateMapper;

    @Override
    public List<Integer> listUserIdByRoleId(Integer roleId) {
        return userRoleRelateMapper.listUserIdByRoleId(roleId);
    }

    @Override
    public List<Integer> listRoleIdByUserId(Integer userId) {
        return userRoleRelateMapper.listRoleIdByUserId(userId);
    }

    @Override
    @Transactional
    public boolean updateUserRoleRelate(Integer userId, List<Integer> roleIdList) {
        Assert.notNull(userId, "userId must not be null");
        removeByMap(ImmutableMap.of("user_id", userId));
        if (!CollectionUtils.isEmpty(roleIdList)) {
            roleIdList.forEach(roleId -> {
                UserRoleRelate userRoleRelate = new UserRoleRelate();
                userRoleRelate.setRoleId(roleId);
                userRoleRelate.setUserId(userId);
                save(userRoleRelate);
            });

            log.debug("用户{}添加了[{}]角色", userId, roleIdList);
        }

        return true;
    }

    @Override
    @Transactional
    public boolean updateRoleUserRelate(Integer roleId, List<Integer> userIdList) {
        Assert.notNull(roleId, "roleId must not be null");
        removeByMap(ImmutableMap.of("role_id", roleId));
        userIdList.forEach(userId -> {
            UserRoleRelate userRoleRelate = new UserRoleRelate();
            userRoleRelate.setRoleId(roleId);
            userRoleRelate.setUserId(userId);
            save(userRoleRelate);
        });

        log.debug("角色{}添加了[{}]用户", roleId, userIdList);
        return true;
    }
}
