package com.bong.patientphoto.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bong.patientphoto.vo.PhotoInfo;

@Repository("PhotoInfoDAO")
public class PhotoInfoDAO implements DataAccess<PhotoInfo> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String namespace = "photo_info_sql";
	@Override
	public int insert(PhotoInfo input) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".insert", input);
	}
	
	public int insert(List<PhotoInfo> input) {
		return sqlSession.insert(namespace + ".insert_list", input);
	}
	
	@Override
	public int update(PhotoInfo input) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace +".update_one", input);
	}
	public int update(List<PhotoInfo> list) {
		return sqlSession.update(namespace+".update", list);
	}
	@Override
	public int delete(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<PhotoInfo> selectAll(PhotoInfo input) {
		return sqlSession.selectList(namespace +".select_all", input);
	}
	
	public List<PhotoInfo> selectThumbnail(PhotoInfo input) {
			return sqlSession.selectList(namespace +".select_thumbnail", input);
	
	}
	@Override
	public List<PhotoInfo> select(PhotoInfo input) {
		return sqlSession.selectList(namespace +".select_list", input);
	}

	@Override
	public PhotoInfo selectOne(PhotoInfo input) {
		return sqlSession.selectOne(namespace + ".select_one", input);
	}
	@Override
	public int count(PhotoInfo input) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int selectTotal(PhotoInfo input) {
		return sqlSession.selectOne(namespace +".select_total", input);
	}

	@Override
	public List<PhotoInfo> select() {
		// TODO Auto-generated method stub
		return null;
	}
}
