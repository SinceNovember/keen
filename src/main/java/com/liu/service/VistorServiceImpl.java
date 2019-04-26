package com.liu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.dao.UserLogDao;
import com.liu.dao.VistorDao;
import com.liu.entity.UserLog;
import com.liu.entity.Vistor;
@Service("vistorService")
public class VistorServiceImpl implements VistorService {
	@Resource
	private VistorDao vistorDao;

	public List<Vistor> listVistor() {
		// TODO Auto-generated method stub
		return vistorDao.listVistor();
	}

	public Integer insertVistor(Vistor vistor) {
		// TODO Auto-generated method stub
		return vistorDao.insertVistor(vistor);
	}

	public Integer countVistor() {
		// TODO Auto-generated method stub
		return vistorDao.countVistor();
	}

	public Integer deleteVistor(Integer id) {
		// TODO Auto-generated method stub
		return vistorDao.deleteVistor(id);
	}


}
