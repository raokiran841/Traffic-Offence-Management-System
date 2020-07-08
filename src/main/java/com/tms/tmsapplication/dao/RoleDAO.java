package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.RoleEO;


public interface RoleDAO {
	
	public List<RoleEO> findAll();
	
	public RoleEO findById(String roleName);
	
	public void save(RoleEO roleEO);
	
	public void deleteById(String roleName);

}
