package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.CategoryDao;
import com.liu.dao.TagDao;
import com.liu.entity.Category;
import com.liu.entity.Tag;
@Service("tagService")
public class TagServiceImpl implements TagService{
	@Resource
	private TagDao tagDao;

	public List<Tag> getTagByAid(Integer aid) {
		return tagDao.getTagByAid(aid);
	}

	public List<Tag> listTag() {
		// TODO Auto-generated method stub
		return tagDao.listTag();
	}

	public Integer getTagArticleCount(Integer tid) {
		// TODO Auto-generated method stub
		return tagDao.getTagArticleCount(tid);
	}

	public Integer insertTag(Tag tag) {
		// TODO Auto-generated method stub
		return tagDao.insertTag(tag);
	}

	public Tag getTagById(Integer tid) {
		// TODO Auto-generated method stub
		return tagDao.getTagById(tid);
	}

	public Integer deleteById(Integer tid) {
		// TODO Auto-generated method stub
		return tagDao.deleteById(tid);
	}

	public Integer updateTag(Tag tag) {
		// TODO Auto-generated method stub
		return tagDao.updateTag(tag);
	}


}
