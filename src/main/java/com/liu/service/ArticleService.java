package com.liu.service;

import java.util.List;
import java.util.Map;

import com.liu.entity.Article;

public interface ArticleService {
	public List<Article>listArticle(Map<String, Object>map);
	public List<Article>listAdminArticle(Map<String, Object>map);
	public Integer countArticle();
	public Article getArticleByAid(Integer articleId);
	public Integer addCommentCount(Integer articleId);
	public Integer insertArticle(Article article);
	public Integer getAidByTitle(String articleTitle);
	public Integer updateArticle(Article article);
	public Integer deleteArticle(Integer articleId);
	public Article getPreArticle(Integer articleId);
	public Article getNextArticle(Integer articleId);	

}
