package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.Image;

@Repository("ImageDAO")
public class ImageDAO implements DataAccess<Image>{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "image_sql";

	@Override
	public int insert(Image input) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace +".insert", input);
	}

	@Override
	public int update(Image input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Image input) {
		// TODO Auto-generated method stub
		return 0;
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
		return sqlSession.selectOne(namespace +".selectOne", input);
	}

	@Override
	public int count(Image input) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
