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
		return dao.insert(input);
	}
	
	public int insert(List<PhotoInfo> input) {
		return dao.insert(input);
	}

	@Override
	public int update(PhotoInfo input) {
		// TODO Auto-generated method stub
		return dao.update(input);
	}
	public int update(List<PhotoInfo> list) {
		return dao.update(list);
	}
	@Override
	public int delete(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PhotoInfo> select() {
		return dao.select();
	}

	public List<PhotoInfo> selectAll(PhotoInfo input) {
		return dao.selectAll(input);
	}
	public List<PhotoInfo> selectThumbnail(PhotoInfo input) {
		return dao.selectThumbnail(input);
	}	

	@Override
	public PhotoInfo selectOne(PhotoInfo input) {
		// TODO Auto-generated method stub
		return dao.selectOne(input);
	}

	@Override
	public int count(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int selectTotal(PhotoInfo input) {
		return dao.selectTotal(input);
	}

	@Override
	public List<PhotoInfo> select(PhotoInfo input) {
		// TODO Auto-generated method stub
		return dao.select(input);
	}
}
