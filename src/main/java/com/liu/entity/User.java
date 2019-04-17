package com.liu.entity;


import org.springframework.web.multipart.MultipartFile;

public class User {
	  	private Integer userId;

	    private String userName;//用户名

	    private String userPass;//用户密码

	    private String userNickname;//用户显示名
	    
	    private String	pageNickname;//页面显示名
	    
	    private String userSignature;//用户个人签名

	    private String userEmail;//用户邮箱

	    private String avatarPath;//头像路径

	    private MultipartFile avatarImage;//头像
	    
	    private String markdownProfile;//markdown简介
	    
	    private String htmlProfile;//html简介
	    
	    private String personTag;//个人标签
	    
	    private String[] tags;//将个人标签分割
		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPass() {
			return userPass;
		}

		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}

		public String getUserNickname() {
			return userNickname;
		}

		public void setUserNickname(String userNickname) {
			this.userNickname = userNickname;
		}

		public String getPageNickname() {
			return pageNickname;
		}

		public void setPageNickname(String pageNickname) {
			this.pageNickname = pageNickname;
		}


		public String getUserSignature() {
			return userSignature;
		}

		public void setUserSignature(String userSignature) {
			this.userSignature = userSignature;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}


		public String getAvatarPath() {
			return avatarPath;
		}

		public void setAvatarPath(String avatarPath) {
			this.avatarPath = avatarPath;
		}

		public MultipartFile getAvatarImage() {
			return avatarImage;
		}

		public void setAvatarImage(MultipartFile avatarImage) {
			this.avatarImage = avatarImage;
		}

		public String getMarkdownProfile() {
			return markdownProfile;
		}

		public void setMarkdownProfile(String markdownProfile) {
			this.markdownProfile = markdownProfile;
		}

		public String getHtmlProfile() {
			return htmlProfile;
		}

		public void setHtmlProfile(String htmlProfile) {
			this.htmlProfile = htmlProfile;
		}

		public String getPersonTag() {
			return personTag;
		}

		public void setPersonTag(String personTag) {
			this.personTag = personTag;
		}

		public String[] getTags() {
			return tags;
		}

		public void setTags(String[] tags) {
			this.tags = tags;
		}

	    
}
