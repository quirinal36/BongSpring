package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.BoardReplyDAO;
import com.bong.patientphoto.vo.BoardReply;

@Component("boardReplyService")
public class BoardReplyService implements DataService<BoardReply> {

	@Autowired
	BoardReplyDAO dao;

	@Override
	public int insert(BoardReply input) {
		return dao.insert(input);
	}

	@Override
	public int update(BoardReply input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardReply input) {
		return dao.delete(input);
	}

	@Override
	public List<BoardReply> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardReply> select(BoardReply input) {
		return dao.select(input);
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
