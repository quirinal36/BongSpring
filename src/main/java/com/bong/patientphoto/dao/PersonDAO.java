package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.Person;

@Repository("PersonDAO")
public class PersonDAO implements DataAccess<Person> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "person_sql";
	@Override
	public int insert(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> select(Person input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person selectOne(Person input) {
		return sqlSession.selectOne(namespace +".select_one", input);
	}

	@Override
	public int count(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
