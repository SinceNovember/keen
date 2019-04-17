package com.liu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
import com.liu.entity.Category;
import com.liu.entity.Tag;
public interface ArticleCategoryRefDao {
	public Integer insertCategoryByAid(@Value("articleId")Integer articleId,@Value("categoryId")Integer categoryId);
	public List<Integer>  getCategoryIdByAid(Integer articleId);
	public Integer deleteByArticleId(Integer articleId);
	public List<ArticleCategoryRef> getArticleByCid(Integer categoryId);
}
