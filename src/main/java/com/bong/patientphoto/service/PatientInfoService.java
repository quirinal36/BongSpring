package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.PatientInfoDAO;
import com.bong.patientphoto.vo.PatientInfo;

@Component("patientInfoService")
public class PatientInfoService implements DataService<PatientInfo> {
	@Autowired
	private PatientInfoDAO dao;
	
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
		return dao.select(input);
	}

	@Override
	public PatientInfo selectOne(PatientInfo input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(PatientInfo input) {
		return dao.count(input);
	}

}
