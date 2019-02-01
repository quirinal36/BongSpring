package com.bong.patientphoto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.UserVO;
@Repository("UserDAO")
public class UserDAO implements PatientPhotoDAO<UserVO> {

	@Override
	public int insert(UserVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO selectOne(UserVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> select(UserVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> select() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVO login(UserVO input) {
		return new UserVO();
	}
}
