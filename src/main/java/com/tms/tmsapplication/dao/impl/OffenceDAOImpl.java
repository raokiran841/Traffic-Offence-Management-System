package com.tms.tmsapplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tmsapplication.dao.OffenceDAO;
import com.tms.tmsapplication.entity.OffenceEO;

@Repository
public class OffenceDAOImpl implements OffenceDAO {
	
	//define EntityManager
	private EntityManager entityManager;
	
	//Contructor Injection
	@Autowired
	public OffenceDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<OffenceEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<OffenceEO> theQuery = 
				currenctSession.createQuery("from OffenceEO order by id desc",OffenceEO.class);
		// Execute Query
		List<OffenceEO> offences = theQuery.getResultList();
		// return
		return offences;
	}

	@Override
	public OffenceEO findById(int offId) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get offence
		OffenceEO offenceEO = currenctSession.get(OffenceEO.class, offId);
		
		// return
		return offenceEO;
	}

	@Override
	public int save(OffenceEO offenceEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save Offence
		int id = (int) currenctSession.save(offenceEO);
		System.out.println(currenctSession.save(offenceEO) + "");
		return id;
	}

	@Override
	public void deleteById(int offId) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currenctSession.createQuery("delete from offenceEO where id=:id")
				.setParameter("id", offId);
		
		
		// delete Offence/ execute Query
		theQuery.executeUpdate();
	}

}
