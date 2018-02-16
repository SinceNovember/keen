package com.liu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liu.model.Blog;

public interface BlogService {
	public List<Blog> getBlogData();
	public List<Blog> listBlog(Map<String,Object>map);
	public Long getTotal(Map<String, Object>map);
	public Blog findById(Integer id);
	public Integer update(Blog blog);
	public Blog getPrevBlog(Date releaseDate);
	public Blog getNextBlog(Date releaseDate);
	public Integer addBlog(Blog blog);
	public Integer deleteBlog(Integer id);
	public Integer getBlogByTypeId(Integer typeId);
	public List<Blog> getAllBlog();
	public List<Blog> listBlogByTypeId(Map<String, Object> map); 
	public Long getTotalByType(Integer id);
}
