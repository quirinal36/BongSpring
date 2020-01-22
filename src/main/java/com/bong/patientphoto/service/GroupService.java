package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.GroupDAO;
import com.bong.patientphoto.vo.Group;

@Component("groupService")
public class GroupService implements DataService<Group> {

	@Autowired
	GroupDAO dao;
	
	@Override
	public int insert(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Group> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> select(Group input) {
		return dao.select(input);
	}

	@Override
	public Group selectOne(Group input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Group input) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
