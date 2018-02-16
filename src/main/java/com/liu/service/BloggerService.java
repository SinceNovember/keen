package com.liu.service;

import com.liu.model.Blogger;

public interface BloggerService {
	public Blogger getByUsername(String username);
	public Blogger getBloggerData();
	public Integer updateBlogger(Blogger blogger);
}
