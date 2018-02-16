package com.liu.model;

import java.util.Date;

 /** 
 * @ClassName: Comment 
 * @author: lyd
 * @date: 2017年9月18日 下午7:25:28 
 * @describe:评论
 */
public class Comment {
	private Integer id;
	private String userIp;//用户Ip地址
	private String content;//所评论的内容
	private Date commentDate;//评论日期
	private Integer state;//是否通过评审
	private Blog blog;//所评论的博客
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
}
