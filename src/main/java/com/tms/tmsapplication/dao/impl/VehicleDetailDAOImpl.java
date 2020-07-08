package com.tms.tmsapplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.tmsapplication.dao.VehicleDetailDAO;
import com.tms.tmsapplication.entity.UserEO;
import com.tms.tmsapplication.entity.VehicleDetailEO;

@Repository
public class VehicleDetailDAOImpl implements VehicleDetailDAO {
	
	//define EntityManager
	private EntityManager entityManager;
		
	//Constructor Injection
	@Autowired
	public VehicleDetailDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<VehicleDetailEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<VehicleDetailEO> theQuery = 
				currenctSession.createQuery("from VehicleDetailEO order by vehId desc",VehicleDetailEO.class);
		// Execute Query
		List<VehicleDetailEO> vehicleDetails = theQuery.getResultList();
		// return
		return vehicleDetails;
	}

	@Override
	public VehicleDetailEO findById(int vehId) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get users
		VehicleDetailEO vehicleDetailEO = currenctSession.get(VehicleDetailEO.class, vehId);
		
		// return
		return vehicleDetailEO;
	}

	@Override
	public void save(VehicleDetailEO vehicleDetailEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save users
		currenctSession.saveOrUpdate(vehicleDetailEO);

	}

	@Override
	public void deleteById(int vehId) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currenctSession.createQuery("delete from VehicleDetailEO where vehId=:name")
				.setParameter("name",vehId);
		
		
		// delete users/ execute Query
		theQuery.executeUpdate();

	}

}
