package com.tms.tmsapplication.service;

import java.util.List;

import com.tms.tmsapplication.entity.OffenceDetailEO;

public interface OffenceDetailService {
	
	public List<OffenceDetailEO> findAll();
	
	public OffenceDetailEO findById(int offenceDetId);
	
	public void save(OffenceDetailEO offenceDetailEO);
	
	public void deleteById(int offenceDetId);
	
	public List<OffenceDetailEO> findOffencesByVehicleNo(String vehNo);
	
	public void updateOffenceStatus(int offDetId);

}
