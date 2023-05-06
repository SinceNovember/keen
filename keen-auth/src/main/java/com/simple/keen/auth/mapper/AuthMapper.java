package com.simple.keen.auth.mapper;

import com.simple.keen.auth.model.query.AuthQuery;
import com.simple.keen.system.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    @Select("select * from t_user where deleted != 1 " +
        "and username =#{username} and password =#{password} ")
    UserVO selectUserIdByUsernameAndPassword(AuthQuery query);
}
