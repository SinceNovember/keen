package com.liu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.BloggerDao;
import com.liu.model.Blogger;
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	@Resource
	private BloggerDao bloggerDao;
	public Blogger getByUsername(String username) {
		return bloggerDao.getByUsername(username);
	}

	public Blogger getBloggerData() {
		return bloggerDao.getBloggerData();
	}

	public Integer updateBlogger(Blogger blogger) {
		return bloggerDao.updateBlogger(blogger);
	}

}
