package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.ArticleCategoryRefDao;
import com.liu.dao.ArticleDao;
import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
@Service("articleCategoryRefService")
public class ArticleCategoryRefServiceImpl implements ArticleCategoryRefService{
	@Resource
	ArticleCategoryRefDao articleCategoryRefDao;

	public Integer insertCategoryByAid(Integer articleId, Integer categoryId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.insertCategoryByAid(articleId, categoryId);
	}

	public List<Integer>  getCategoryIdByAid(Integer articleId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.getCategoryIdByAid(articleId);
	}

	public Integer deleteByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.deleteByArticleId(articleId);
	}

	public List<ArticleCategoryRef> getArticleByCid(Integer categoryId) {
		// TODO Auto-generated method stub
		return articleCategoryRefDao.getArticleByCid(categoryId);
	}


}
