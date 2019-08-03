package com.bong.patientphoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bong.patientphoto.dao.PersonDAO;
import com.bong.patientphoto.vo.Person;

@Component("personService")
public class PersonService implements DataService<Person> {
	@Autowired
	PersonDAO dao;
	
	@Override
	public int insert(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> select(Person input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person selectOne(Person input) {
		return dao.selectOne(input);
	}

	@Override
	public int count(Person input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
