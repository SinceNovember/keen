package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.entity.UserLog;

public interface UserLogDao {
	List<UserLog> listLog(Map<String,Object> map);
	Integer getLogCount();
	Integer insertLog(UserLog userLog);
	Integer deleteLog(Integer id);
	Integer deleteAllLog();
}
