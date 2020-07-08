package com.tms.tmsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.VehicleDetailDAO;
import com.tms.tmsapplication.entity.VehicleDetailEO;
import com.tms.tmsapplication.service.VehicleDetailService;

@Service
public class VehicleDetailServiceImpl implements VehicleDetailService {
	
	//inject DAO
	private VehicleDetailDAO vehicleDetailDAO;
	
	@Autowired
	public VehicleDetailServiceImpl(VehicleDetailDAO theVehicleDetailDAO) {
		vehicleDetailDAO = theVehicleDetailDAO;
	}

	@Override
	@Transactional
	public List<VehicleDetailEO> findAll() {
		// TODO Auto-generated method stub
		return vehicleDetailDAO.findAll();
	}

	@Override
	@Transactional
	public VehicleDetailEO findById(int vehId) {
		// TODO Auto-generated method stub
		return vehicleDetailDAO.findById(vehId);
	}

	@Override
	@Transactional
	public void save(VehicleDetailEO vehicleDetailEO) {
		// TODO Auto-generated method stub
		vehicleDetailDAO.save(vehicleDetailEO);
	}

	@Override
	@Transactional
	public void deleteById(int vehId) {
		// TODO Auto-generated method stub
		vehicleDetailDAO.deleteById(vehId);
	}

}
