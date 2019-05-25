package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.PhotoInfoDAO;
import com.bong.patientphoto.vo.PhotoInfo;

@Component("photoInfoService")
public class PhotoInfoService implements DataService<PhotoInfo> {
	@Autowired
	PhotoInfoDAO dao;
	
	@Override
	public int insert(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PhotoInfo> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoInfo> select(PhotoInfo input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoInfo selectOne(PhotoInfo input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
