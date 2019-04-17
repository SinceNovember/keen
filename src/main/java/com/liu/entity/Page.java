package com.liu.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @ClassName: Page 
 * @author: lyd
 * @date: 2019年4月17日 下午3:02:09 
 * @describe:页面实体类
 */
public class Page {
	private Integer pageId;
	private Integer pageFlag;//1:主页 2:文章页 3:归档页 4:分类页 5:标签页 6:关于页
	private String pageTag;//页面标签
	private String imagePath;//图片路径
	private MultipartFile pageImage;//文章的背景图
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public Integer getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(Integer pageFlag) {
		this.pageFlag = pageFlag;
	}
	public String getPageTag() {
		return pageTag;
	}
	public void setPageTag(String pageTag) {
		this.pageTag = pageTag;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public MultipartFile getPageImage() {
		return pageImage;
	}
	public void setPageImage(MultipartFile pageImage) {
		this.pageImage = pageImage;
	}

	
}
