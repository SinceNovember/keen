package com.liu.dao;

import java.util.List;

import com.liu.entity.Article;
import com.liu.entity.Category;
import com.liu.entity.Upload;
import com.liu.entity.User;
public interface UserDao {
	public User getUser(Integer userId);
	public Integer updateUser(User user);
	public User getUserByUsername(String userName);
}
