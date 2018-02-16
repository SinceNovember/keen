package com.liu.service;

import java.util.List;
import java.util.Map;

import com.liu.model.BlogType;

public interface BlogTypeService {
	public List<BlogType> getBlogTypeData();
	public BlogType getById(Integer id);
	public List<BlogType> listByPage(Map<String, Object>map);
	public Long getTotal();
	public Integer addBlogType(BlogType blogType);
	public Integer updateBlogType(BlogType blogType);
	public Integer deleteBlogType(Integer id);
}
