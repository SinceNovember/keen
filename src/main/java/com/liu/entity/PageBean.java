package com.liu.entity;

/**
 * 
 * @ClassName: PageBean 
 * @author: lyd
 * @date: 2019年4月17日 下午3:02:23 
 * @describe:分页实体
 */
public class PageBean {
	private int page;//第几页
	private int pageSize;//每页记录数
	private int start;//起始页
//	private int totalPage;
	public PageBean(int page, int pageSize) {
		super();
		this.page = (page-1)*pageSize;//用于数据库limit起始
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	
}
