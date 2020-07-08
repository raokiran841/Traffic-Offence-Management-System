package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.UserEO;

public interface UserDAO {
	
	public List<UserEO> findAll();
	
	public UserEO findById(String username);
	
	public void save(UserEO userEO);
	
	public void deleteById(String username);

}
