package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.AppUserDAO;
import com.bong.patientphoto.dao.BoardBaseDAO;
import com.bong.patientphoto.vo.AppUser;
import com.bong.patientphoto.vo.BoardBase;

@Component("appUserService")
public class AppUserService implements DataService<AppUser> {

	@Autowired
	AppUserDAO dao;

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
