package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.BoardBase;
import com.bong.patientphoto.vo.BoardPhoto;

@Repository("BoardBaseDAO")
public class BoardBaseDAO implements DataAccess<BoardBase> {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "boardbase_sql";
	
	@Override
	public int insert(BoardBase input) {
		return sqlSession.insert(namespace + ".insert", input);
	}
	public int insertBoardPhoto(BoardBase input) {
		return sqlSession.insert(namespace + ".insertPhoto", input);
	}
	public int insertPhotos(List<BoardPhoto> input) {
		return sqlSession.insert(namespace + ".insert_photos", input);
	}
	@Override
	public int update(BoardBase input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardBase input) {
		return sqlSession.delete(namespace + ".delete", input);
	}

	@Override
	public List<BoardBase> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardBase> select(BoardBase input) {
		return sqlSession.selectList(namespace +".select_all", input);
	}

	@Override
	public BoardBase selectOne(BoardBase input) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".select_one", input);
	}
	

	@Override
	public int count(BoardBase input) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace +".count", input);
	}

}
