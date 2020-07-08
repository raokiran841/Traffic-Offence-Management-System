package com.tms.tmsapplication.service;

import java.util.List;

import com.tms.tmsapplication.entity.VehicleDetailEO;

public interface VehicleDetailService {
	
	public List<VehicleDetailEO> findAll();
	
	public VehicleDetailEO findById(int vehId);
	
	public void save(VehicleDetailEO vehicleDetailEO);
	
	public void deleteById(int vehId);

}
