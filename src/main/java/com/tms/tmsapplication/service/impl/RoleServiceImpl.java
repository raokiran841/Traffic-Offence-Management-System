package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.RoleDAO;
import com.tms.tmsapplication.entity.RoleEO;
import com.tms.tmsapplication.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	//inject DAO
	private RoleDAO roleDAO;
	
	@Autowired
	public RoleServiceImpl(RoleDAO theRoleDAO) {
		roleDAO = theRoleDAO;
	}

	@Override
	@Transactional
	public List<RoleEO> findAll() {
		// TODO Auto-generated method stub
		return roleDAO.findAll();
	}

	@Override
	@Transactional
	public RoleEO findById(String roleName) {
		// TODO Auto-generated method stub
		return roleDAO.findById(roleName);
	}

	@Override
	@Transactional
	public void save(RoleEO roleEO) {
		// TODO Auto-generated method stub
		roleDAO.save(roleEO);
	}

	@Override
	@Transactional
	public void deleteById(String roleName) {
		// TODO Auto-generated method stub
		roleDAO.deleteById(roleName);
	}

}
