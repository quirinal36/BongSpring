package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.ImageDAO;
import com.bong.patientphoto.vo.Image;

@Component("imageService")
public class ImageService implements DataService<Image> {
	@Autowired
	ImageDAO dao;

	@Override
	public int insert(Image input) {
		return dao.insert(input);
	}

	@Override
	public int update(Image input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Image input) {
		return dao.delete(input);
	}

	@Override
	public List<Image> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> select(Image input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image selectOne(Image input) {
		return dao.selectOne(input);
	}

	@Override
	public int count(Image input) {
		// TODO Auto-generated method stub
		return 0;
	}
}
