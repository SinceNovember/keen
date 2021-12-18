package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.simple.common.exception.AdmintoryException;
import com.simple.common.model.constant.PropertyConstant;
import com.simple.system.dao.MenuPermissionRelateMapper;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.entity.MenuPermissionRelate;
import com.simple.system.model.entity.User;
import com.simple.system.model.enums.PermissionType;
import com.simple.system.model.params.MenuPermissionRelateParam;
import com.simple.system.service.MenuPermissionRelateService;
import com.simple.system.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class MenuPermissionRelateServiceImpl  extends ServiceImpl<MenuPermissionRelateMapper, MenuPermissionRelate> implements MenuPermissionRelateService {

    @Resource
    private MenuPermissionRelateMapper menuPermissionRelateMapper;


    @Resource
    private RoleService roleService;

    @Override
    public Map<PermissionType, List<Integer>> listMenuPermissionIdGroupByType(Integer menuId) {
        LambdaQueryWrapper<MenuPermissionRelate> lambdaQueryWrapper = Wrappers.lambdaQuery();;
        lambdaQueryWrapper.eq(MenuPermissionRelate::getMenuId, menuId);

        List<MenuPermissionRelate> menuPermissionRelateList = this.list(lambdaQueryWrapper);
        Map<PermissionType, List<Integer>> menuPermissionRelateMap = menuPermissionRelateList.stream().collect(Collectors.groupingBy(MenuPermissionRelate::getPermissionType, Collectors.mapping(MenuPermissionRelate::getPermissionId, Collectors.toList())));
        return menuPermissionRelateMap;
    }

    /**
     * 更新按钮权限
     * @param menuPermissionRelateParam
     */
    @Override
    @Transactional(rollbackFor = AdmintoryException.class)
    public void updateMenuPermission(MenuPermissionRelateParam menuPermissionRelateParam) {
        //删除
        LambdaQueryWrapper<MenuPermissionRelate> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MenuPermissionRelate::getMenuId, menuPermissionRelateParam.getMenuId())
                .eq(MenuPermissionRelate::getPermissionType, menuPermissionRelateParam.getType());
        remove(lambdaQueryWrapper);

        menuPermissionRelateParam.getPermissionIdList().forEach(permissionId ->{
            MenuPermissionRelate menuPermissionRelate = new MenuPermissionRelate();
            menuPermissionRelate.setMenuId(menuPermissionRelateParam.getMenuId());
            menuPermissionRelate.setPermissionType(menuPermissionRelateParam.getType());
            menuPermissionRelate.setPermissionId(permissionId);
            save(menuPermissionRelate);
        });
    }

    @Override
    /**
     * 判断该用户是否有按钮的权限
     */
    public boolean hasMenuPermission(User user, MenuDTO menu) {
        if (Objects.equals(user.getUsername(), PropertyConstant.ADMIN_USERNAME) || menu.getAlwaysShow()) {
            return true;
        }
        //判断该菜单是否分配到该用户
        MenuPermissionRelate userPermissionRelate = menuPermissionRelateMapper.getMenuPermissionRelate(menu.getId(), user.getUserId(), PermissionType.USER);
        if (userPermissionRelate == null) {
            MenuPermissionRelate deptPermissionRelate = menuPermissionRelateMapper.getMenuPermissionRelate(menu.getId(), user.getDeptId(), PermissionType.DEPT);
            if (deptPermissionRelate == null) {
                List<Integer> roleIdList = roleService.listRoleIdByUserId(user.getUserId());
                if(CollectionUtils.isEmpty(roleIdList)) {
                    return false;
                }
                List<MenuPermissionRelate> rolePermissionRelateList = menuPermissionRelateMapper.listMenuPermissionRelate(menu.getId(), roleIdList, PermissionType.ROLE);
                if (CollectionUtils.isEmpty(rolePermissionRelateList)) {
                    return false;
                }
            }
        }
        return true;
    }
}