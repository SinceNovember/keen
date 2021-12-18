package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.simple.common.exception.AdmintoryException;
import com.simple.common.model.constant.PropertyConstant;
import com.simple.common.utils.StringUtils;
import com.simple.metadata.service.SystemConfigService;
import com.simple.monitor.service.SessionService;
import com.simple.system.dao.DeptMapper;
import com.simple.system.dao.UserMapper;
import com.simple.system.dao.UserRoleRelateMapper;
import com.simple.system.model.dto.UserDTO;
import com.simple.system.model.entity.Dept;
import com.simple.system.model.entity.User;
import com.simple.system.model.enums.UserStatus;
import com.simple.system.model.params.PasswordParam;
import com.simple.system.model.params.UserParam;
import com.simple.system.model.vo.UserCondition;
import com.simple.system.service.UserRoleRelateService;
import com.simple.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import static com.simple.common.model.constant.CommonConstant.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {

    @Resource
    private UserRoleRelateService userRoleRelateService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private UserRoleRelateMapper userRoleRelateMapper;

    @Resource
    private SessionService sessionService;

    @Resource
    private SystemConfigService systemConfigService;

    @Override
    public IPage<UserDTO> pageUser(UserCondition userCondition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(StringUtils.isNotEmpty(userCondition.getNickname()), User::getNickname, userCondition.getNickname())
                .eq(userCondition.getSsex() != null, User::getSsex, userCondition.getSsex())
                .eq(userCondition.getStatus() != null, User::getStatus, userCondition.getStatus())
                .eq(userCondition.getDeptId() != null, User::getDeptId, userCondition.getDeptId())
                .eq(User::getDeleted, false)
                .orderByDesc(User::getCreateTime);
        Page<User> userPage = new Page<>(pageIndex, pageSize);
        IPage<UserDTO> userIPage = userMapper.selectPage(userPage, userLambdaQueryWrapper).convert(this::convertTo);
        userIPage.getRecords().forEach(userDTO -> {
            if (userDTO.getDeptId() != null) {
                userDTO.setDeptName(deptMapper.selectById(userDTO.getDeptId()).getDeptName());
            }
            userDTO.setRoleNameList(userRoleRelateMapper.listRoleNameByUserId(userDTO.getUserId()));
            userDTO.setOnline(sessionService.isOnline(userDTO.getUserId()));
        });
        return userIPage;
    }

    @Override
    public UserDTO getUserDetailById(int id) {
        UserDTO userDTO = userMapper.getUserDetailById(id);
        userDTO.setDeptName(Optional.ofNullable(deptMapper.selectById(userDTO.getDeptId())).orElseGet(Dept::new).getDeptName());
        userDTO.setRoleId(userRoleRelateMapper.listRoleIdByUserId(id));
        return userDTO;
    }

    @Override
    public User getUserByUsername(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();;
        lambdaQueryWrapper.eq(User::getUsername, username)
        .eq(User::getDeleted, false);
        return userMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public UserDTO getUserDetailByToken(String token) {
         UserDTO userDTO =  Optional.of(userMapper.getUserByToken(token)).map(user -> {
             String deptName = deptMapper.getDeptNameById(user.getDeptId());
             user.setDeptName(Optional.ofNullable(deptName).orElse(""));
            return user;
        }).orElseThrow(() -> new AdmintoryException("token获取用户失败"));

        return userDTO;
    }

    @Override
    public List<UserDTO> listOnlineUser(Integer userId) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(User::getDeleted, false);
        List<UserDTO> userList = convertTo(userMapper.selectList(userLambdaQueryWrapper));
        return userList.stream().filter(user -> !Objects.equals(userId, user.getUserId()) && sessionService.isOnline(user.getUserId())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveUser(UserParam userParam) {
        User user = userParam.convertTo();
        user.setCreateTime(new Date());
        this.save(user);
        userRoleRelateService.updateUserRoleRelate(user.getUserId(), userParam.getRoleId());
    }

    @Override
    @Transactional
    public void updateUser(UserParam userParam) {
        User user = userParam.convertTo();
        user.setUpdateTime(new Date());
        this.updateById(user);
        userRoleRelateService.updateUserRoleRelate(user.getUserId(), userParam.getRoleId());
    }

    @Override
    public void updateUserDept(UserParam userParam) {
        User user = this.getById(userParam.getUserId());
        user.setDeptId(userParam.getDeptId());
        this.updateById(user);
    }

    @Override
    public void logicDeleteUserByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            User user = this.getById(id);
            if (null != user) {
                user.setDeleted(true);
                this.updateById(user);
                userRoleRelateMapper.deleteByMap(ImmutableMap.of("user_id", user.getUserId()));
            }
        });
    }

    /**
     * 启用或禁用用户
     * @param ids
     */
    @Override
    public void enableOrDisableUser(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            User user = this.getById(id);
            if (null != user) {
                if (user.getStatus().getValue() == 0) {
                    user.setStatus(UserStatus.VALID);
                } else {
                    user.setStatus(UserStatus.LOCK);
                }
                this.updateById(user);
            }
        });
    }

    @Override
    public void updatePassword(PasswordParam passwordParam) {
        User user = this.getById(passwordParam.getUserId());
        if (!Objects.equals(user.getPassword(), passwordParam.getPassword())) {
            throw new AdmintoryException("输入密码错误");
        }
        user.setPassword(passwordParam.getNewPassword());
        this.updateById(user);
    }

    @Override
    public void resetPassword(Integer userId) {
        User user = this.getById(userId);
        user.setPassword(Optional.ofNullable(systemConfigService.getConfigValueByConfigName("resetPassword")).orElse(PropertyConstant.USER_DEFAULT_PASSWORD));
        this.updateById(user);
    }

    @Override
    public String getUserAvatar(String userId) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(User::getAvatar).eq(User::getUserId, userId);
        return getOne(queryWrapper).getAvatar();
    }

    @Override
    public UserDTO convertTo(User user) {
        Assert.notNull(user, "user must not be null");
        return new UserDTO().covertFrom(user);
    }

    @Override
    public List<UserDTO> convertTo(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }

        return users.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
