package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.RegistrationEO;

public interface RegistrationDAO {
	
	public List<RegistrationEO> findAll();
	
	public RegistrationEO findById(String vehNo);
	
	public void save(RegistrationEO registrationEO);
	
	public void deleteById(String vehNo);
	
	public List<String> vehiclesFromOwner(int ownId);

}
