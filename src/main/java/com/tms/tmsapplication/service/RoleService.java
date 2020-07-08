package com.tms.tmsapplication.service;

import java.util.List;

import com.tms.tmsapplication.entity.RoleEO;

public interface RoleService {
	
	public List<RoleEO> findAll();
	
	public RoleEO findById(String roleName);
	
	public void save(RoleEO roleEO);
	
	public void deleteById(String roleName);

}
