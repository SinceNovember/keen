package com.liu.model;

 /** 
 * @ClassName: BlogType 
 * @author: lyd
 * @date: 2017年9月18日 下午7:17:39 
 * @describe:博客类型
 */
public class BlogType {
	private Integer id;
	private String typeName;//博客名称
	private Integer orderNum;//优先级
	private Integer blogCount; //博客总数
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	
}
