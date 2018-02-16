package com.liu.dao;

import com.liu.model.Blogger;

public interface BloggerDao {
	public Blogger getByUsername(String username);
	public Blogger getBloggerData();
	public Integer updateBlogger(Blogger blogger);
}
