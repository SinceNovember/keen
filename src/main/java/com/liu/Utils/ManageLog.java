package com.liu.Utils;

import java.util.Date;

import com.liu.controller.LoginController;
import com.liu.entity.UserLog;

public class ManageLog {
	
	public UserLog insertLog(String type,String detail)
	{
		Date date=new Date();
		UserLog userLog=new UserLog();
		userLog.setDetail(detail);
		userLog.setIp(LoginController.LoginIp);
		userLog.setTime(date);
		userLog.setType(type);
		return userLog;
	}
}
