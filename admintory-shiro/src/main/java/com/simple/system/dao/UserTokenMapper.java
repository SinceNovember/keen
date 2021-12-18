package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
}
