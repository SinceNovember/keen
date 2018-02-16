package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.PhotoDao;
import com.liu.model.Photo;
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
	@Resource
	private PhotoDao photoDao;
	public void insertphoto(Photo photo) {
		photoDao.insertphoto(photo);

	}

	public List<Photo> selectphoto() {
		return photoDao.selectphoto();
	}

}
