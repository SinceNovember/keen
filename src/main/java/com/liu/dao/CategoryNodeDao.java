package com.liu.dao;

import java.util.List;

import com.liu.entity.Article;
import com.liu.entity.Category;
public interface CategoryNodeDao {
	public List<Category>getAllParent();
	
}
