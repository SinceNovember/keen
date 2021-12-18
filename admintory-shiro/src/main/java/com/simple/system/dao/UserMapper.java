package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.dto.TreeDTO;
import com.simple.system.model.dto.UserDTO;
import com.simple.system.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where user_id =#{userId} and deleted = 0")
    UserDTO getUserDetailById(Integer userId);

    @Select("select * from t_user where user_id =#{userId} and deleted = 0")
    User getUserById(Integer userId);

    @Select("select dept")
    String getDeptNameById(Integer userId);

    @Select("select * from t_user where dept_id = #{deptId} and deleted = 0")
    List<UserDTO> getUserDetailByDeptId(int deptId);

    @Select("select * from t_user a join t_user_token b on a.user_id = b.user_id where token =#{token} and deleted = 0")
    UserDTO getUserByToken(String token);

    @Select("select user_id as id, username as label, 0 as 'nodeType' from t_user where dept_id = #{deptId} and deleted = 0")
    @ResultType(TreeDTO.class)
    List<TreeDTO> listUserTreeModelByDeptId(int deptId);
}
