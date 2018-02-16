package com.liu.model;

 /** 
 * @ClassName: Blogger 
 * @author: lyd
 * @date: 2017年9月18日 下午7:14:21 
 * @describe:用户
 */
public class Blogger {
	private Integer id;//id
	private String username;//用户名
	private String password;//密码
	private String profile;//个人介绍
	private String nickname;//博主姓名
	private String sign;//签名
	private String imagename;//头像地址
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
}
