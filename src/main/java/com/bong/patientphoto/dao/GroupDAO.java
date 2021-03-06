package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.Group;

@Repository("GroupDAO")
public class GroupDAO implements DataAccess<Group>{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "group_sql";
	
	@Override
	public int insert(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int join(Group input) {
		return sqlSession.insert(namespace + ".join_group", input);
	}

	@Override
	public int update(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Group> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> select(Group input) {
		return sqlSession.selectList(namespace +".select_all", input);
	}
	public List<Group> selectMy(Group input) {
		return sqlSession.selectList(namespace +".select_my", input);
	}
	@Override
	public Group selectOne(Group input) {
		return sqlSession.selectOne(namespace +".select_one", input);
	}

	@Override
	public int count(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
