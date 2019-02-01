package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.UserVO;
@Repository("UserDAO")
public class UserDAO implements PatientPhotoDAO<UserVO> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String namespace = "user_sql";
	
	@Override
	public int insert(UserVO input) {
		return sqlSession.insert(namespace+".insert", input);
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

	public UserVO login(UserVO user) {
		return sqlSession.selectOne(namespace +".login", user);
	}
}
