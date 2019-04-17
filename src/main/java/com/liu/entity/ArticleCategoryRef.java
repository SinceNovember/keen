package com.liu.entity;


public class ArticleCategoryRef {
		private Integer articleId;//文章id
		
		private Integer categoryId;//分类id
		
		private Article article;//其下文章
		
		public Integer getArticleId() {
			return articleId;
		}
		public void setArticleId(Integer articleId) {
			this.articleId = articleId;
		}
		public Integer getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}
		public Article getArticle() {
			return article;
		}
		public void setArticle(Article article) {
			this.article = article;
		}


		
}
