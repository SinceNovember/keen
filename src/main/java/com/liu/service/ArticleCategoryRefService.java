package com.liu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
import com.liu.entity.Category;
import com.liu.entity.Tag;
public interface ArticleCategoryRefService {
	public Integer insertCategoryByAid(Integer articleId,Integer categoryId);
	public List<Integer>  getCategoryIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public List<ArticleCategoryRef> getArticleByCid(Integer categoryId);
}
