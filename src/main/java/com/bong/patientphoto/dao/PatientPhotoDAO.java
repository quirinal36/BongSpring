package com.bong.patientphoto.dao;

import java.util.List;

public interface PatientPhotoDAO<T> {
	// 입력
	public int insert(T input);
	// 수정
	public int update(T input);
	// 삭제
	public int delete(T input);
	// 선택 1개
	public T selectOne(T input);
	// 조건 선택
	public List<T>select(T input);
	// 전체선택
	public List<T>select();
}
