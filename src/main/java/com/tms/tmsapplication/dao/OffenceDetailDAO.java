package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.OffenceDetailEO;

public interface OffenceDetailDAO {
	
	public List<OffenceDetailEO> findAll();
	
	public OffenceDetailEO findById(int offenceDetId);
	
	public void save(OffenceDetailEO offenceDetailEO);
	
	public void deleteById(int offenceDetId);
	
	public List<OffenceDetailEO> findOffencesByVehicleNo(String vehNo);
	
	public void updateOffenceStatus(int offDetId);

}
