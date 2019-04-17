package com.liu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.PageDao;
import com.liu.entity.Page;
@Service("pageService")
public class PageServiceImpl implements PageService {

	@Resource
	private PageDao pageDao;
	public Page getPage(Integer pageFlag) {
		// TODO Auto-generated method stub
		return pageDao.getPage(pageFlag);
	}

	public Integer updatePage(Page page) {
		// TODO Auto-generated method stub
		return pageDao.updatePage(page);
	}

}
