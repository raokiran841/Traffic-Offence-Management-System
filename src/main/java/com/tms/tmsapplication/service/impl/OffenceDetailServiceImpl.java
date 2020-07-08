package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.OffenceDetailDAO;
import com.tms.tmsapplication.entity.OffenceDetailEO;
import com.tms.tmsapplication.service.OffenceDetailService;

@Service
@Transactional
public class OffenceDetailServiceImpl implements OffenceDetailService {
	
	//inject DAO
	private OffenceDetailDAO offenceDetailDAO;
	
	@Autowired
	public OffenceDetailServiceImpl(OffenceDetailDAO theOffenceDetailDAO) {
		offenceDetailDAO = theOffenceDetailDAO;
	}

	@Override
	@Transactional
	public List<OffenceDetailEO> findAll() {
		// TODO Auto-generated method stub
		return offenceDetailDAO.findAll();
	}

	@Override
	@Transactional
	public OffenceDetailEO findById(int offenceDetId) {
		// TODO Auto-generated method stub
		return offenceDetailDAO.findById(offenceDetId);
	}

	@Override
	@Transactional
	public void save(OffenceDetailEO offenceDetailEO) {
		// TODO Auto-generated method stub
		offenceDetailDAO.save(offenceDetailEO);
	}

	@Override
	@Transactional
	public void deleteById(int offenceDetId) {
		// TODO Auto-generated method stub
		offenceDetailDAO.deleteById(offenceDetId);
	}

	@Override
	public List<OffenceDetailEO> findOffencesByVehicleNo(String vehNo) {
		// TODO Auto-generated method stub
		return offenceDetailDAO.findOffencesByVehicleNo(vehNo);
	}

	@Override
	public void updateOffenceStatus(int offDetId) {
		// TODO Auto-generated method stub
		offenceDetailDAO.updateOffenceStatus(offDetId);
	}
	

}
