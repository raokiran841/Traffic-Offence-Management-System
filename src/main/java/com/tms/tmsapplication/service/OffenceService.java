package com.tms.tmsapplication.service;

import java.util.List;
import com.tms.tmsapplication.entity.OffenceEO;

public interface OffenceService {
	
	public List<OffenceEO> findAll();
	
	public OffenceEO findById(int offId);
	
	public int save(OffenceEO offenceEO);
	
	public void deleteById(int offId);


}
