package com.liu.entity;

import java.util.List;

public class Category {
    private Integer categoryId;//分类id

    private Integer categoryPid;//分类父亲id

    private String categoryName;//分类名称

    private String categoryDescription;//分类描述

    private Integer categoryOrder;//分类顺序
    
    private List<Category> childrenCategory;//分类得所有子分类

    private Category parentCategory;//分类得父亲分类
	/**
     * 文章数量(非数据库字段)
     */
    private Integer articleCount;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryPid() {
		return categoryPid;
	}

	public void setCategoryPid(Integer categoryPid) {
		this.categoryPid = categoryPid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Integer getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(Integer categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public List<Category> getChildrenCategory() {
		return childrenCategory;
	}

	public void setChildrenCategory(List<Category> childrenCategory) {
		this.childrenCategory = childrenCategory;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

}
