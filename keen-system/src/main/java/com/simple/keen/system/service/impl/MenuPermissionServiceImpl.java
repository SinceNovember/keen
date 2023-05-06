package com.simple.keen.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.keen.system.mapper.MenuPermissionMapper;
import com.simple.keen.system.model.dto.MenuDTO;
import com.simple.keen.system.model.dto.MenuPermissionDTO;
import com.simple.keen.system.model.dto.UserDTO;
import com.simple.keen.system.model.entity.MenuPermission;
import com.simple.keen.system.model.enums.PermissionType;
import com.simple.keen.system.model.query.MenuPermissionQuery;
import com.simple.keen.system.service.IMenuPermissionService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
@Service
@RequiredArgsConstructor
public class MenuPermissionServiceImpl extends
    ServiceImpl<MenuPermissionMapper, MenuPermission> implements IMenuPermissionService {

    @Override
    public Map<PermissionType, List<Integer>> listMenuPermissionIdGroupByType(
        MenuPermissionQuery query) {
        List<MenuPermission> menuPermissionList =
            list(Wrappers.<MenuPermission>lambdaQuery()
                .eq(MenuPermission::getMenuId, query.getMenuId()));

        return menuPermissionList.stream()
            .collect(Collectors.groupingBy(MenuPermission::getPermissionType,
                Collectors.mapping(MenuPermission::getPermissionId, Collectors.toList())));
    }

    @Override
    public boolean hasMenuPermission(UserDTO userDTO, MenuDTO menuDTO) {
        if (menuDTO.isAlwaysShow()) {
            return true;
        }
        //先判断该用户是否有权限
        MenuPermissionDTO userMenuPermission = baseMapper.getMenuPermission(menuDTO.getId(),
            userDTO.getId(),
            PermissionType.USER);
        if (userMenuPermission == null) {
            //在判断用户部门是否有权限
            MenuPermissionDTO deptMenuPermission = baseMapper.getMenuPermission(menuDTO.getId(),
                userDTO.getDeptId(), PermissionType.DEPT);
            if (deptMenuPermission == null) {
                if (CollectionUtils.isEmpty(userDTO.getRoleIds())) {
                    return false;
                }
                //判断用户拥有的角色是否包含此菜单权限
                if (count(Wrappers.<MenuPermission>lambdaQuery()
                    .eq(MenuPermission::getMenuId, menuDTO.getId())
                    .eq(MenuPermission::getPermissionType, PermissionType.ROLE)
                    .in(MenuPermission::getPermissionId, userDTO.getRoleIds())) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenuPermission(MenuPermissionQuery query) {

        //先删除原先的权限关联
        this.remove(Wrappers.<MenuPermission>lambdaQuery()
            .eq(MenuPermission::getMenuId, query.getMenuId()));

        query.getMenuPermissionMap().forEach((k, v) -> {
            v.forEach(id -> {
                MenuPermission menuPermission = new MenuPermission();
                menuPermission.setMenuId(query.getMenuId());
                menuPermission.setPermissionId(id);
                menuPermission.setPermissionType(k);
                this.save(menuPermission);
            });
        });
    }

}
