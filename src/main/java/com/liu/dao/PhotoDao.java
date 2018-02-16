package com.liu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.liu.model.Photo;

public interface PhotoDao {
	public void insertphoto(Photo photo);
	public List<Photo> selectphoto();
	
}
