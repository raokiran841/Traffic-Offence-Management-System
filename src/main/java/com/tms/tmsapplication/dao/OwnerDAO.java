package com.tms.tmsapplication.dao;

import java.util.List;

import com.tms.tmsapplication.entity.OwnerEO;

public interface OwnerDAO {
	
	public List<OwnerEO> findAll();
	
	public OwnerEO findById(int ownerId);
	
	public void save(OwnerEO ownerEO);
	
	public void deleteById(int ownerId);

}
