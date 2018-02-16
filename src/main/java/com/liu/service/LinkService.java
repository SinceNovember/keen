package com.liu.service;

import java.util.List;
import java.util.Map;

import com.liu.model.Link;

public interface LinkService {
	public List<Link> getLinkData();

	// 分页获取友情链接
	public List<Link> listLinkData(Map<String, Object> map);

	// 获取总记录数
	public Long getTotal();

	// 添加友情链接
	public Integer addLink(Link link);

	// 更新友情链接
	public Integer updateLink(Link link);

	// 删除友情链接
	public Integer deleteLink(Integer id);
}
