package com.liu.model;

 /** 
 * @ClassName: Link 
 * @author: lyd
 * @date: 2017年9月18日 下午7:28:11 
 * @describe:链接
 */
public class Link {
	private Integer id;
	private String linkname;//链接名称
	private String linkurl;//链接地址
	private Integer orderNum;//优先级
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
}
