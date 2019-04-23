package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.entity.Article;
import com.sun.mail.iap.Literal;
public interface ArticleDao {
	public List<Article>listArticle(Map<String, Object>map);
	public List<Article>listAdminArticle(Map<String, Object>map);
	public Integer commentReduce(Integer article_id);
	public List<Article>lisRecenttArticle(Integer pageSize);
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
