package com.liu.service;

import com.liu.entity.Page;

public interface PageService {
	public Page getPage(Integer pageFlag);
	public Integer updatePage(Page page);
}
