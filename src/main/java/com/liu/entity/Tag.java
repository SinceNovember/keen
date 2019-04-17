package com.liu.entity;

/**
 * 
 * @ClassName: Tag 
 * @author: lyd
 * @date: 2019年4月17日 下午3:02:39 
 * @describe:标签实体
 */
public class Tag {
    private Integer tagId;

    private String tagName;//标签名
    
    private Integer articleCount;//文章数
    
    private String fontSize;//字体大小
    
	private String fontColor;//字体颜色

	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
    public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
}
