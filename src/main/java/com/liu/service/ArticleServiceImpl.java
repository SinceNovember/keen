package com.liu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.ArticleDao;
import com.liu.entity.Article;
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
	@Resource
	private ArticleDao articleDao;

	public List<Article> listAdminArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.listAdminArticle(map);
	}
	public Article getArticleByAid(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByAid(articleId);
	}
	public Integer countArticle() {
		// TODO Auto-generated method stub
		return articleDao.countArticle();
	}
	public Integer insertArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.insertArticle(article);
	}
	public Integer getAidByTitle(String articleTitle) {
		// TODO Auto-generated method stub
		return articleDao.getAidByTitle(articleTitle);
	}
	public Integer updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.updateArticle(article);
	}
	public Integer deleteArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.deleteArticle(articleId);
	}
	public List<Article> listArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.listArticle(map);
	}
	public Article getPreArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.getPreArticle(articleId);
	}
	public Article getNextArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.getNextArticle(articleId);
	}
	public Integer addCommentCount(Integer articleId) {
		// TODO Auto-generated method stub
		return articleDao.addCommentCount(articleId);
	}



}
