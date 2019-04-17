package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.CategoryNodeDao;
import com.liu.dao.UploadDao;
import com.liu.entity.Category;
import com.liu.entity.Upload;
@Service("uploadService")
public class UploadServiceImpl implements UploadService{
	@Resource
	private UploadDao uploadDao;

	public Integer insertPath(Upload upload) {
		// TODO Auto-generated method stub
		return uploadDao.insertPath(upload);
	}




}
