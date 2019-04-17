package com.liu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.UserLogDao;
import com.liu.entity.UserLog;
@Service("userLogService")
public class UserLogServiceImpl implements UserLogService {
	@Resource
	private UserLogDao userLogDao;

	public List<UserLog> listLog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userLogDao.listLog(map);
	}
	public Integer getLogCount() {
		// TODO Auto-generated method stub
		return userLogDao.getLogCount();
	}
	public Integer insertLog(UserLog userLog) {
		// TODO Auto-generated method stub
		return userLogDao.insertLog(userLog);
	}

	public Integer deleteLog(Integer id) {
		// TODO Auto-generated method stub
		return userLogDao.deleteLog(id);
	}

	public Integer deleteAllLog() {
		// TODO Auto-generated method stub
		return userLogDao.deleteAllLog();
	}





}
