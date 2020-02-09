package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.CompanyDAO;
import com.bong.patientphoto.vo.Company;

@Component("companyService")
public class CompanyService implements DataService<Company> {
	@Autowired
	CompanyDAO dao;

	@Override
	public int insert(Company input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Company input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Company input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Company> select() {
		return dao.select();
	}

	@Override
	public List<Company> select(Company input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company selectOne(Company input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Company input) {
		// TODO Auto-generated method stub
		return 0;
	}


}
