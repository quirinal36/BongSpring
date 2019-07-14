package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.service.DataService;
import com.bong.patientphoto.vo.PatientInfo;
import com.bong.patientphoto.vo.PatientPhotoInfo;

@Repository("PatientInfoDAO")
public class PatientInfoDAO implements DataService<PatientInfo> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "patient_info_sql";
	
	@Override
	public int insert(PatientInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(PatientInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PatientInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PatientInfo> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientInfo> select(PatientInfo input) {
		return sqlSession.selectList(namespace +".select", input);
	}

	@Override
	public PatientInfo selectOne(PatientInfo input) {
		return sqlSession.selectOne(namespace +".select_one", input);
	}

	@Override
	public int count(PatientInfo input) {
		return sqlSession.selectOne(namespace +".count", input);
	}
	public List<PatientPhotoInfo> selectDetail(PatientInfo input){
		return sqlSession.selectList(namespace + ".select_detail", input);
	}
}
