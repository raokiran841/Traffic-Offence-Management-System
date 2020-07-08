package com.tms.tmsapplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.tmsapplication.dao.UserDAO;
import com.tms.tmsapplication.entity.UserEO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	//define EntityManager
	private EntityManager entityManager;
		
	//Constructor Injection
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<UserEO> findAll() {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		// Query
		Query<UserEO> theQuery = 
				currenctSession.createQuery("from UserEO",UserEO.class);
		// Execute Query
		List<UserEO> users = theQuery.getResultList();
		// return
		return users;
	}

	@Override
	public UserEO findById(String username) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// get users
		UserEO userEO = currenctSession.get(UserEO.class, username);
		
		// return
		return userEO;
	}

	@Override
	public void save(UserEO userEO) {
		// session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		//save users
		currenctSession.saveOrUpdate(userEO);
	}

	@Override
	public void deleteById(String username) {
		// Session
		Session currenctSession = entityManager.unwrap(Session.class);
		
		// Query
		Query theQuery = 
				currenctSession.createQuery("delete from UserEO where username=:name")
				.setParameter("name",username);
		
		
		// delete users/ execute Query
		theQuery.executeUpdate();
	}

}
