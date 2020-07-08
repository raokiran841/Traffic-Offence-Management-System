package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.OffenceEO;

public interface OffenceDAO {
	
	public List<OffenceEO> findAll();
	
	public OffenceEO findById(int offId);
	
	public int save(OffenceEO offenceEO);
	
	public void deleteById(int offId);

}
