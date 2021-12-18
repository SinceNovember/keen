package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.entity.MenuPermissionRelate;
import com.simple.system.model.enums.PermissionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色关系Mapper
 */
@Mapper
public interface MenuPermissionRelateMapper extends BaseMapper<MenuPermissionRelate> {

    @Select(" select * from t_menu_permission where menu_id =#{menuId} and permission_id =#{permissionId} and permission_type =#{permissionType}")
    MenuPermissionRelate getMenuPermissionRelate(Integer menuId, Integer permissionId, PermissionType permissionType);

    @Select({" <script>" ,
            "select * from t_menu_permission where menu_id =#{menuId} ",
            " and permission_id in <foreach collection=\"permissionIdList\" item=\"id\" open=\"(\" close=\")\" separator=\",\">",
            "#{id}",
            "</foreach>",
            "  and permission_type =#{permissionType}",
            "</script>"})
    List<MenuPermissionRelate> listMenuPermissionRelate(Integer menuId, List<Integer> permissionIdList, PermissionType permissionType);

//    @Select("select ")
//    List<Integer> listMenuPermissionRelateByMenuId(Integer menuId, PermissionType type);
//
//    @Select("select role_id from t_user_role where user_id =#{userId}")
//    List<Integer> listRoleIdByUserId(Integer userId);
}
