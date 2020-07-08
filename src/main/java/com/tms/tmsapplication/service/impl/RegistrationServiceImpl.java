package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.RegistrationDAO;
import com.tms.tmsapplication.entity.RegistrationEO;
import com.tms.tmsapplication.service.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	
	//inject DAO
	private RegistrationDAO registrationDAO;
	
	@Autowired
	public RegistrationServiceImpl(RegistrationDAO theRegistrationDAO) {
		registrationDAO = theRegistrationDAO;
	}

	@Override
	@Transactional
	public List<RegistrationEO> findAll() {
		// TODO Auto-generated method stub
		return registrationDAO.findAll();
	}

	@Override
	@Transactional
	public RegistrationEO findById(String vehNo) {
		// TODO Auto-generated method stub
		return registrationDAO.findById(vehNo);
	}

	@Override
	@Transactional
	public void save(RegistrationEO registrationEO) {
		// TODO Auto-generated method stub
		registrationDAO.save(registrationEO);
	}

	@Override
	@Transactional
	public void deleteById(String vehNo) {
		// TODO Auto-generated method stub
		registrationDAO.deleteById(vehNo);
	}

	@Override
	public List<String> vehiclesFromOwner(int ownId) {
		// TODO Auto-generated method stub
		return registrationDAO.vehiclesFromOwner(ownId);
	}

}
