package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.dto.OptionDTO;
import com.simple.system.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select role_id as value, role_name as label from t_role where deleted = 0 and status = 1")
    List<OptionDTO> listRoleOption();

    @Select("select role_name as name, count(*) as value from t_role a join t_user_role b on a.role_id  = b.role_id join t_user c on b.user_id  = c.user_id group by role_name order by count(*) desc")
    List<Map<String, Integer>> countRoleMember();


}
