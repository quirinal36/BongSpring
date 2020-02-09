package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.BoardBaseDAO;
import com.bong.patientphoto.vo.BoardBase;
import com.bong.patientphoto.vo.BoardPhoto;
import com.bong.patientphoto.vo.BoardReply;

@Component("boardBaseService")
public class BoardBaseService implements DataService<BoardBase> {

	@Autowired
	BoardBaseDAO dao;
	
	@Override
	public int insert(BoardBase input) {
		return dao.insert(input);
	}
	public int insertBoardPhoto(BoardBase input) {
		return dao.insertBoardPhoto(input);
	}
	public int insertPhotos(List<BoardPhoto> input) {
		return dao.insertPhotos(input);
	}
	@Override
	public int update(BoardBase input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardBase input) {
		return dao.delete(input);
	}

	@Override
	public List<BoardBase> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardBase> select(BoardBase input) {
		// TODO Auto-generated method stub
		return dao.select(input);
	}

	@Override
	public BoardBase selectOne(BoardBase input) {
		// TODO Auto-generated method stub
		return dao.selectOne(input);
	}

	@Override
	public int count(BoardBase input) {
		// TODO Auto-generated method stub
		return dao.count(input);
	}

}
