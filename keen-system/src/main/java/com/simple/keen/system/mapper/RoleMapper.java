package com.simple.keen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.common.base.OptionModel;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.system.model.dto.RoleDTO;
import com.simple.keen.system.model.entity.Role;
import com.simple.keen.system.model.query.RoleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("<script>"
        + "select * from t_role where deleted = 0 "
        + "<if test=\"roleName != null and roleName != ''\">"
        + "and role_name like concat('%', #{roleName}, '%') "
        + "</if>"
        + "<if test=\"roleTag != null and roleTag != ''\">"
        + "and role_tag like concat('%', #{roleTag}, '%') "
        + "</if>"
        + "<if test=\"description != null and description != ''\">"
        + "and description like concat('%', #{description}, '%') "
        + "</if>"
        + "</script>")
    List<RoleDTO> selectRoleList(RoleQuery roleQuery);

    @Select("<script>"
        + "select id as value, role_name as label from t_role"
        + " where deleted = 0 and status = 1 order by order_num desc"
        + "</script>")
    List<OptionModel> selectRoleOptionModelList();

    @Select("<script>"
        + "select id as value, role_name as title from t_role "
        + "where deleted = 0 order by order_num desc"
        + "</script>")
    List<TreeModel> selectRoleTreeModelList();

}
