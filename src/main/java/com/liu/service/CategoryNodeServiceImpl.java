package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.CategoryNodeDao;
import com.liu.entity.Category;
@Service("categoryNodeService")
public class CategoryNodeServiceImpl implements CategoryNodeService{
	@Resource
	private CategoryNodeDao categoryNodeDao;

	public List<Category> getAllParent() {
		// TODO Auto-generated method stub
		return categoryNodeDao.getAllParent();
	}



}
