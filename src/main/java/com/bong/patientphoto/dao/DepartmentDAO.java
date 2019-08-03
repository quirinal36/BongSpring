package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.Department;

@Repository("DepartmentDAO")
public class DepartmentDAO implements DataAccess<Department> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "department_sql";

	@Override
	public int insert(Department input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Department input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Department input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Department> select() {
		return sqlSession.selectList(namespace + ".select_all");
	}

	@Override
	public List<Department> select(Department input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department selectOne(Department input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Department input) {
		// TODO Auto-generated method stub
		return 0;
	}
}
