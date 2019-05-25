package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.UserDAO;
import com.bong.patientphoto.vo.UserVO;

@Component("userService")
public class UserService implements PatientPhotoService<UserVO> {
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int insert(UserVO input) {
		input.setPassword(passwordEncoder.encode(input.getPassword()));
		return dao.insert(input);
	}

	@Override
	public int update(UserVO input) {
		return dao.update(input);
	}

	@Override
	public int delete(UserVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO selectOne(UserVO input) {
		return dao.login(input);
	}

	@Override
	public List<UserVO> select(UserVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> select() {
		return dao.select();
	}

}
