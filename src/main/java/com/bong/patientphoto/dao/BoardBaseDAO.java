package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.BoardBase;

@Repository("BoardBaseDAO")
public class BoardBaseDAO implements DataAccess<BoardBase> {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "boardbase_sql";
	
	@Override
	public int insert(BoardBase input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardBase input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardBase input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardBase> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardBase> select(BoardBase input) {
		return sqlSession.selectList(namespace +".select", input);
	}

	@Override
	public BoardBase selectOne(BoardBase input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(BoardBase input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
