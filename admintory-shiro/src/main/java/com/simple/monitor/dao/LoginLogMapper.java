package com.simple.monitor.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.monitor.model.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    @Select("select count(id) from t_login_log where date_format(login_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
    int countLoginLogByLoginDate(Date date);
}
