package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.BoardDAO;
import com.bong.patientphoto.dao.OPRecordDAO;
import com.bong.patientphoto.vo.OPRecord;

@Component("oprecordService")
public class OPRecordService implements DataService<OPRecord> {

	@Autowired
	OPRecordDAO dao;
	
	@Override
	public int insert(OPRecord input) {
		// TODO Auto-generated method stub
		return dao.insert(input);
	}

	@Override
	public int update(OPRecord input) {
		// TODO Auto-generated method stub
		return dao.update(input);
	}

	@Override
	public int delete(OPRecord input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OPRecord> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public List<OPRecord> select(OPRecord input) {
		// TODO Auto-generated method stub
		return dao.select(input);
	}

	@Override
	public OPRecord selectOne(OPRecord input) {
		// TODO Auto-generated method stub
		return dao.selectOne(input);
	}

	@Override
	public int count(OPRecord input) {
		// TODO Auto-generated method stub
		return dao.count(input);
	}

}
