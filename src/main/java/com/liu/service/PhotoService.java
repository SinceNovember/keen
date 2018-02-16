package com.liu.service;

import java.util.List;

import com.liu.model.Photo;

public interface PhotoService {
	public void insertphoto(Photo photo);
	public List<Photo> selectphoto();
}
