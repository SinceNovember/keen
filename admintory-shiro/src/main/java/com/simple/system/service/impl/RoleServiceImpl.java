package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.common.exception.RelateExistException;
import com.simple.common.utils.StringUtils;
import com.simple.system.dao.RoleMapper;
import com.simple.system.dao.UserRoleRelateMapper;
import com.simple.system.model.dto.OptionDTO;
import com.simple.system.model.dto.RoleDTO;
import com.simple.system.model.entity.Role;
import com.simple.system.model.entity.UserRoleRelate;
import com.simple.system.model.enums.RoleStatus;
import com.simple.system.model.vo.RoleCondition;
import com.simple.system.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 角色Service
 */
@Service
public class RoleServiceImpl  extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleRelateMapper userRoleRelateMapper;

    @Override
    public IPage<RoleDTO> pageRole(RoleCondition roleCondition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = Wrappers.lambdaQuery();
        roleLambdaQueryWrapper.like(StringUtils.isNotEmpty(roleCondition.getRoleName()), Role::getRoleName, roleCondition.getRoleName())
                .like(StringUtils.isNotEmpty(roleCondition.getRoleTag()), Role::getRoleTag, roleCondition.getRoleTag())
                .eq(roleCondition.getStatus() != null, Role::getStatus, roleCondition.getStatus())
                .eq(Role::getDeleted, false)
                .orderByDesc(Role::getOrderNum);
        Page<Role> rolePage = new Page<>(pageIndex, pageSize);
        IPage<RoleDTO> roleIPage = roleMapper.selectPage(rolePage, roleLambdaQueryWrapper).convert(this::convertTo);
        return roleIPage;
    }

    @Override
    public RoleDTO getRoleDetailById(int id) {
        return this.convertTo(getById(id));
    }

    @Override
    public List<Integer> listRoleIdByUserId(Integer userId) {
        return userRoleRelateMapper.listRoleIdByUserId(userId);
    }

    /**
     * 获取角色-成员前6
     * @return
     */
    @Override
    public List<Map<String, Integer>> countRoleMemberTop6() {
        return roleMapper.countRoleMember().stream().limit(6).collect(Collectors.toList());
    }

    @Override
    public void logicDeleteRoleByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            this.logicDeleteRoleById(Integer.valueOf(id));
        });
    }

    @Override
    public void logicDeleteRoleById(int id) {
        LambdaQueryWrapper<UserRoleRelate> wrapper = Wrappers.lambdaQuery();;
        wrapper.eq(UserRoleRelate::getRoleId, id);
        Integer count = userRoleRelateMapper.selectCount(wrapper);
        if(count > 0){
            throw new RelateExistException("角色下存在用户");
        }
        Role role = roleMapper.selectById(id);
        if (null != role) {
            role.setDeleted(true);
            roleMapper.updateById(role);
        }
    }

    @Override
    public void enableOrDisableRole(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            Role role = roleMapper.selectById(id);
            if (null != role) {
                role.setStatus(role.getStatus().getValue() == 0 ? RoleStatus.VALID : RoleStatus.LOCK);
                roleMapper.updateById(role);
            }
        });
    }

    /**
     * 角色下拉
     * @return
     */
    @Override
    public List<OptionDTO> listRoleOption() {
        return roleMapper.listRoleOption();
    }


    @Override
    public RoleDTO convertTo(Role role) {
        Assert.notNull(role, "role must not be null");
        return new RoleDTO().covertFrom(role);
    }

    @Override
    public List<RoleDTO> convertTo(List<Role> roles) {
        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptyList();
        }

        return roles.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }

}
