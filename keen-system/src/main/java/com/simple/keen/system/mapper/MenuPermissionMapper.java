package com.simple.keen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.system.model.dto.MenuPermissionDTO;
import com.simple.keen.system.model.entity.MenuPermission;
import com.simple.keen.system.model.enums.PermissionType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
@Mapper
public interface MenuPermissionMapper extends BaseMapper<MenuPermission> {

    @Select(" select * from t_menu_permission where menu_id =#{menuId} "
        + "and permission_id =#{permissionId} and permission_type =#{permissionType}")
    MenuPermissionDTO getMenuPermission(@Param("menuId") Integer menuId,
        @Param("permissionId") Integer permissionId,
        @Param("permissionType") PermissionType permissionType);

    @Select(" <script>"
        + "select * from t_menu_permission "
        + "where menu_id =#{menuId} "
        + "and permission_id in "
        + "<foreach collection=\"permissionIdList\" item=\"id\" open=\"(\" close=\") \" separator=\",\">"
        + "#{id}"
        + "</foreach>"
        + "and permission_type =#{permissionType}"
        + "</script>")
    List<MenuPermission> listMenuPermission(Integer menuId, List<Integer> permissionIdList,
        PermissionType permissionType);

}
