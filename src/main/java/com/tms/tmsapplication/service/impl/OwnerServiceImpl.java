package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.OwnerDAO;
import com.tms.tmsapplication.entity.OwnerEO;
import com.tms.tmsapplication.service.OwnerService;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{
	
	//inject DAO
	private OwnerDAO ownerDAO;
		
	@Autowired
	public OwnerServiceImpl(OwnerDAO theOwnerDAO) {
		ownerDAO = theOwnerDAO;
	}

	@Override
	@Transactional
	public List<OwnerEO> findAll() {
		// TODO Auto-generated method stub
		return ownerDAO.findAll();
	}

	@Override
	@Transactional
	public OwnerEO findById(int ownerId) {
		// TODO Auto-generated method stub
		return ownerDAO.findById(ownerId);
	}

	@Override
	@Transactional
	public void save(OwnerEO ownerEO) {
		// TODO Auto-generated method stub
		ownerDAO.save(ownerEO);
	}

	@Override
	@Transactional
	public void deleteById(int ownerId) {
		// TODO Auto-generated method stub
		ownerDAO.deleteById(ownerId);
	}

}
