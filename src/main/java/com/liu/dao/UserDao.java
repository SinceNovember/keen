package com.liu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.liu.model.User;

//@Repository
public interface UserDao {
	public List<User>findAllUser();
}
