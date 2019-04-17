package com.liu.dao;

import com.liu.entity.Page;

public interface PageDao {
	public Page getPage(Integer pageFlag);
	public Integer updatePage(Page page);
}
