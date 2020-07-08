package com.tms.tmsapplication.dao.impl;

import java.util.Currency;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.tmsapplication.dao.RegistrationDAO;
import com.tms.tmsapplication.entity.RegistrationEO;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	
	//define EntityManager
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<RegistrationEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<RegistrationEO> theQuery = 
				currenctSession.createQuery("from RegistrationEO",RegistrationEO.class);
		// Execute Query
		List<RegistrationEO> registrations = theQuery.getResultList();
		// return
		return registrations;
	}

	@Override
	public RegistrationEO findById(String vehNo) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get users
		RegistrationEO registrationEO = currenctSession.get(RegistrationEO.class, vehNo);
		
		// return
		return registrationEO;
	}

	@Override
	public void save(RegistrationEO registrationEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save users
		currenctSession.saveOrUpdate(registrationEO);
	}

	@Override
	public void deleteById(String vehNo) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currenctSession.createQuery("delete from RegistrationEO where vehNo=:name")
				.setParameter("name",vehNo);
		
		// delete users/ execute Query
		theQuery.executeUpdate();
	}

	@Override
	public List<String> vehiclesFromOwner(int ownId) {
		// Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currentSession.createQuery("select r.vehNo from RegistrationEO as r where r.ownerId=:ownId")
				.setParameter("ownId", ownId);
		List<String> vehicleNumbers = theQuery.getResultList();
		
		//return
		return vehicleNumbers;
	}

}
