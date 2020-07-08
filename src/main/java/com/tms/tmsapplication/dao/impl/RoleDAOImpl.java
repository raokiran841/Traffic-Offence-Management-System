package com.tms.tmsapplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.tmsapplication.dao.RoleDAO;
import com.tms.tmsapplication.entity.RoleEO;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	//define EntityManager
	private EntityManager entityManager;
			
	//Constructor Injection
	@Autowired
	public RoleDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<RoleEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<RoleEO> theQuery = 
				currenctSession.createQuery("from RoleEO",RoleEO.class);
		// Execute Query
		List<RoleEO> roles = theQuery.getResultList();
		// return
		return roles;
	}

	@Override
	public RoleEO findById(String roleName) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get users
		RoleEO roleEO = currenctSession.get(RoleEO.class, roleName);
		
		// return
		return roleEO;
	}

	@Override
	public void save(RoleEO roleEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save users
		currenctSession.saveOrUpdate(roleEO);
	}

	@Override
	public void deleteById(String roleName) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currenctSession.createQuery("delete from RoleEO where roleName=:name")
				.setParameter("name",roleName);
		
		
		// delete users/ execute Query
		theQuery.executeUpdate();

	}

}
