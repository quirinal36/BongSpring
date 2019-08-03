package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.DepartmentDAO;
import com.bong.patientphoto.vo.Department;

@Component("departmentService")
public class DepartmentService implements DataService<Department > {
	@Autowired
	DepartmentDAO dao;

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
		return dao.select();
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
