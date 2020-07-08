package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.VehicleDetailEO;


public interface VehicleDetailDAO {
	
	public List<VehicleDetailEO> findAll();
	
	public VehicleDetailEO findById(int vehId);
	
	public void save(VehicleDetailEO vehicleDetailEO);
	
	public void deleteById(int vehId);

}
