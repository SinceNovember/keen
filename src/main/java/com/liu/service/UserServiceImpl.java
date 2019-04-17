package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.UserDao;
import com.liu.entity.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public User getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(userName);
	}


}
