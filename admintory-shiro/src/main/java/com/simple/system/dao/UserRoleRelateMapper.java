package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.entity.UserRoleRelate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色关系Mapper
 */
@Mapper
public interface UserRoleRelateMapper extends BaseMapper<UserRoleRelate> {

    @Select("select user_id from t_user_role where role_id =#{roleId}")
    List<Integer> listUserIdByRoleId(Integer roleId);

    @Select("select role_id from t_user_role where user_id =#{userId}")
    List<Integer> listRoleIdByUserId(Integer userId);

    @Select("select role_name from t_user_role a join t_role b on a.role_id  = b.role_id   where user_id =#{userId}")
    List<String> listRoleNameByUserId(Integer userId);
}
