package com.liu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
import com.liu.entity.ArticleTagRef;
public interface ArticleTagRefDao {
//	public Integer insertTagByAid(ArticleTagRef articleTagRef);
	public Integer insertTagByAid(@Value("articleId")Integer articleId,@Value("tagId")Integer tagId);
	public List<Integer> getTagIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public Integer countArticleByTagId(Integer tagId);
	public List<ArticleTagRef>  getArticleByTid(Integer tagId);
}
