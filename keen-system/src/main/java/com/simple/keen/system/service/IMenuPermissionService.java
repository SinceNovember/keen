package com.simple.keen.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.keen.system.model.dto.MenuDTO;
import com.simple.keen.system.model.dto.UserDTO;
import com.simple.keen.system.model.entity.MenuPermission;
import com.simple.keen.system.model.enums.PermissionType;
import com.simple.keen.system.model.query.MenuPermissionQuery;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
public interface IMenuPermissionService extends IService<MenuPermission> {

    /**
     * 根据菜单id获取权限列表并按照权限类别进行分组
     *
     * @param query 查询
     * @return Map<权限类别, List<权限Id>>
     */
    Map<PermissionType, List<Integer>> listMenuPermissionIdGroupByType(MenuPermissionQuery query);

    /**
     * 判断当前用户是否有此菜单的权限
     *
     * @param userDTO 用户id
     * @param menuDTO 菜单id X
     */
    boolean hasMenuPermission(UserDTO userDTO, MenuDTO menuDTO);

    /**
     * 修改菜单权限
     *
     * @param query 查询
     */
    void updateMenuPermission(MenuPermissionQuery query);

}
