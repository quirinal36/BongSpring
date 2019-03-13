package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bong.patientphoto.vo.OPRecord;


@Repository("OPRecordDAO")
public class OPRecordDAO implements DataAccess<OPRecord> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "oprecord_sql";
	
	@Override
	public int insert(OPRecord input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OPRecord input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OPRecord input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OPRecord> select() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".select_all");
	}

	@Override
	public List<OPRecord> select(OPRecord input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OPRecord selectOne(OPRecord input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(OPRecord input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
