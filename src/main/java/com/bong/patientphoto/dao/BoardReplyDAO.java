package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.BoardReply;

@Repository("BoardReplyDAO")
public class BoardReplyDAO implements DataAccess<BoardReply> {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "boardreply_sql";

	@Override
	public int insert(BoardReply input) {
		return sqlSession.insert(namespace + ".insert", input);
	}

	@Override
	public int update(BoardReply input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardReply input) {
		return sqlSession.delete(namespace + ".delete", input);
	}

	@Override
	public List<BoardReply> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardReply> select(BoardReply input) {
		return sqlSession.selectList(namespace +".select_all", input);
	}

	@Override
	public BoardReply selectOne(BoardReply input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(BoardReply input) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
