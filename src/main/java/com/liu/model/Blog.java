package com.liu.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

 /** 
 * @ClassName: Blog 
 * @author: lyd
 * @date: 2017年9月18日 下午7:25:43 
 * @describe:博客实体
 */
public class Blog {
	private Integer id; //博客id
	private String title;//博客标题
	private String summary;//博客内容简介
	private Date releaseDate;//日期
	private Integer clickHit;//点击数
	private Integer replyHit;//回复数
	private String content;//正文内容
	private String contentNoTag;//正文不带标签
	private String keyWord;//关键字
	private BlogType blogType;//博客类型
	private Integer blogCount;//博客数量，非博客实际属性，用于根据发布日期归档查询
	private String releaseDateStr;//发布日期的字符串，只取年月
	private List<String>imageList=new LinkedList<String>();//正文内容所包含的图片地址
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public Integer getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentNoTag() {
		return contentNoTag;
	}
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", summary=" + summary + ", releaseDate=" + releaseDate
				+ ", clickHit=" + clickHit + ", replyHit=" + replyHit + ", content=" + content + ", contentNoTag="
				+ contentNoTag + ", keyWord=" + keyWord + ", blogType=" + blogType + ", blogCount=" + blogCount
				+ ", releaseDateStr=" + releaseDateStr + "]";
	}
	
	
}
