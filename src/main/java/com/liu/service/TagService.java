package com.liu.service;

import java.util.List;

import com.liu.entity.Article;
import com.liu.entity.Category;
import com.liu.entity.Tag;

public interface TagService {
	public List<Tag>getTagByAid(Integer aid);
	public List<Tag>listTag();
	public Integer getTagArticleCount(Integer tid);
	public Integer insertTag(Tag tag);
	public Tag getTagById(Integer tid);
	public Integer deleteById(Integer tid);
	public Integer updateTag(Tag tag);

}
