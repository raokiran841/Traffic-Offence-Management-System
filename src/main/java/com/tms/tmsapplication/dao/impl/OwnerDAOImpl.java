package com.tms.tmsapplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.tmsapplication.dao.OwnerDAO;
import com.tms.tmsapplication.entity.OwnerEO;

@Repository
public class OwnerDAOImpl implements OwnerDAO {
	
	//define EntityManager
	private EntityManager entityManager;
		
	//Constructor Injection
	@Autowired
	public OwnerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<OwnerEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<OwnerEO> theQuery = 
				currenctSession.createQuery("from OwnerEO order by ownerId desc",OwnerEO.class);
		// Execute Query
		List<OwnerEO> owners = theQuery.getResultList();
		// return
		return owners;
	}

	@Override
	public OwnerEO findById(int ownerId) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get users
		OwnerEO ownerEO = currenctSession.get(OwnerEO.class, ownerId);
		
		// return
		return ownerEO;
	}

	@Override
	public void save(OwnerEO ownerEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save users
		currenctSession.saveOrUpdate(ownerEO);
	}

	@Override
	public void deleteById(int ownerId) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currenctSession.createQuery("delete from OwnerEO where ownerId=:name")
				.setParameter("name",ownerId);
		
		
		// delete users/ execute Query
		theQuery.executeUpdate();
	}

}
