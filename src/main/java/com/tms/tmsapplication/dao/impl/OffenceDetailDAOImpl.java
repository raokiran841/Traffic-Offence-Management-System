package com.tms.tmsapplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.tmsapplication.dao.OffenceDetailDAO;
import com.tms.tmsapplication.entity.OffenceDetailEO;
import com.tms.tmsapplication.entity.RegistrationEO;
@Repository
public class OffenceDetailDAOImpl implements OffenceDetailDAO {
	
	//define EntityManager
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OffenceDetailEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<OffenceDetailEO> theQuery = 
				currenctSession.createQuery("from OffenceDetailEO order by offenceDetId desc",OffenceDetailEO.class);
		// Execute Query
		List<OffenceDetailEO> offenceDets = theQuery.getResultList();
		// return
		return offenceDets;
	}

	@Override
	public OffenceDetailEO findById(int offenceDetId) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get users
		OffenceDetailEO offenceDetailEO = currenctSession.get(OffenceDetailEO.class, offenceDetId);
		
		// return
		return offenceDetailEO;
	}

	@Override
	public void save(OffenceDetailEO offenceDetailEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save users
		currenctSession.saveOrUpdate(offenceDetailEO);
	}

	@Override
	public void deleteById(int offenceDetId) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
			currenctSession.createQuery("delete from OffenceDetailEO where offenceDetId=:name")
				.setParameter("name",offenceDetId);
		
		// delete users/ execute Query
		theQuery.executeUpdate();
	}

	@Override
	public List<OffenceDetailEO> findOffencesByVehicleNo(String vehicleNo) {
		// Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = currentSession.createQuery("from OffenceDetailEO where vehNo=:vehicleNo",
				OffenceDetailEO.class).setParameter("vehicleNo", vehicleNo);
		List<OffenceDetailEO> OffDetEO = theQuery.getResultList();
		
		// return
		return OffDetEO;
	}

	@Override
	public void updateOffenceStatus(int offDetId) {
		// Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = currentSession.createQuery("update OffenceDetailEO set offenceStatus=:status where offenceDetId=:id")
				.setParameter("status","paid")
				.setParameter("id", offDetId);
		int result = theQuery.executeUpdate();
		System.out.println("Updated id: "+offDetId+" with result: "+result);
	}

}
