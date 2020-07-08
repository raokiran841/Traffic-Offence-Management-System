package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.UserDAO;
import com.tms.tmsapplication.entity.UserEO;
import com.tms.tmsapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	//inject DAO
	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}	

	@Override
	@Transactional
	public List<UserEO> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public UserEO findById(String username) {
		// TODO Auto-generated method stub
		return userDAO.findById(username);
	}

	@Override
	@Transactional
	public void save(UserEO userEO) {
		// TODO Auto-generated method stub
		userDAO.save(userEO);
	}

	@Override
	@Transactional
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		userDAO.deleteById(username);
	}

}
