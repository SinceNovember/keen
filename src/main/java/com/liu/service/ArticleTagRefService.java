package com.liu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
import com.liu.entity.ArticleTagRef;
public interface ArticleTagRefService {
//	public Integer insertTagByAid(ArticleTagRef articleTagRef);
	public Integer insertTagByAid(Integer articleId,Integer tagId);
	public List<Integer> getTagIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public Integer countArticleByTagId(Integer tagId);
	public List<ArticleTagRef> getArticleByTid(Integer tagId);

}
