package com.liu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.liu.dao.BlogDao;
import com.liu.model.Blog;
@Service("blogService")
public class BlogServiceImpl implements BlogService {
	@Resource
	private BlogDao blogDao;
	public List<Blog> getBlogData() {
		return blogDao.getBlogData();
	}

	public List<Blog> listBlog(Map<String,Object>map) {

		return blogDao.listBlog(map);
	}

	public Long getTotal(Map<String, Object> map) {

		return blogDao.getTotal();
	}

	public Blog findById(Integer id) {

		return blogDao.findById(id);
	}

	public Integer update(Blog blog) {

		return blogDao.update(blog);
	}


	public Integer addBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.addBlog(blog);
	}

	public Integer deleteBlog(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.deleteBlog(id);
	}

	public Integer getBlogByTypeId(Integer typeId) {
		// TODO Auto-generated method stub
		return blogDao.getBlogByTypeId(typeId);
	}

	public List<Blog> getAllBlog() {
		// TODO Auto-generated method stub
		return blogDao.getAllBlog();
	}

	public List<Blog> listBlogByTypeId(Map<String, Object> map) {
		return blogDao.listBlogByTypeId(map);
	}

	public Long getTotalByType(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.getTotalByType(id);
	}

	public Blog getPrevBlog(Date releaseDate) {
		// TODO Auto-generated method stub
		return blogDao.getPrevBlog(releaseDate);
	}

	public Blog getNextBlog(Date releaseDate) {
		// TODO Auto-generated method stub
		return blogDao.getNextBlog(releaseDate);
	}








}
