package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.AppUser;
import com.bong.patientphoto.vo.BoardBase;

@Repository("AppUserDAO")
public class AppUserDAO implements DataAccess<AppUser> {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "appuser_sql";

	@Override
	public int insert(AppUser input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AppUser input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AppUser input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AppUser> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUser> select(AppUser input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser selectOne(AppUser input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(AppUser input) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
