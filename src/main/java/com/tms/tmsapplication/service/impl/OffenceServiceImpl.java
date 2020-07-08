package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.OffenceDAO;
import com.tms.tmsapplication.entity.OffenceEO;
import com.tms.tmsapplication.service.OffenceService;

@Service
@Transactional
public class OffenceServiceImpl implements OffenceService {
	
	//inject DAO
	private OffenceDAO offenceDAO;
	
	@Autowired
	public OffenceServiceImpl(OffenceDAO theOffenceDAO) {
		offenceDAO = theOffenceDAO;
	}

	@Override
	@Transactional
	public List<OffenceEO> findAll() {
		// TODO Auto-generated method stub
		return offenceDAO.findAll();
	}

	@Override
	@Transactional
	public OffenceEO findById(int offId) {
		// TODO Auto-generated method stub
		return offenceDAO.findById(offId);
	}

	@Override
	@Transactional
	public int save(OffenceEO offenceEO) {
		// TODO Auto-generated method stub
		int id = offenceDAO.save(offenceEO);
		return id;
	}

	@Override
	@Transactional
	public void deleteById(int offId) {
		// TODO Auto-generated method stub
		offenceDAO.deleteById(offId);
	}

}
