package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.Company;

@Repository("CompanyDAO")
public class CompanyDAO implements DataAccess<Company> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "company_sql";

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
		return sqlSession.selectList(namespace + ".select_all");
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
