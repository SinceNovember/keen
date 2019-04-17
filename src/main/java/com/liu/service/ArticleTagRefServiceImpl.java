package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.ArticleTagRefDao;
import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
import com.liu.entity.ArticleTagRef;
@Service("articleTagRefService")
public class ArticleTagRefServiceImpl implements ArticleTagRefService{
	@Resource
	ArticleTagRefDao articleTagRefDao;

	public Integer insertTagByAid(Integer articleId, Integer tagId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.insertTagByAid(articleId, tagId);
	}

	public List<Integer> getTagIdByAid(Integer articleId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.getTagIdByAid(articleId);
	}

	public Integer deleteByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.deleteByArticleId(articleId);
	}

	public Integer countArticleByTagId(Integer tagId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.countArticleByTagId(tagId);
	}

	public List<ArticleTagRef>  getArticleByTid(Integer tagId) {
		// TODO Auto-generated method stub
		return articleTagRefDao.getArticleByTid(tagId);
	}



	
}
