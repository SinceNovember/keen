package com.simple.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.entity.MenuPermissionRelate;
import com.simple.system.model.entity.User;
import com.simple.system.model.entity.UserRoleRelate;
import com.simple.system.model.enums.PermissionType;
import com.simple.system.model.params.MenuPermissionRelateParam;

import java.util.List;
import java.util.Map;

public interface MenuPermissionRelateService extends IService<MenuPermissionRelate>  {

    Map<PermissionType, List<Integer>> listMenuPermissionIdGroupByType(Integer menuId);

    void updateMenuPermission(MenuPermissionRelateParam menuPermissionRelateParam);

    /**
     * 判断用户是否有菜单的权限
     * @param user
     * @param menu
     * @return
     */
    boolean hasMenuPermission(User user, MenuDTO menu);

}
