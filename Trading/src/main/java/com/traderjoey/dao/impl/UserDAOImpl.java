package com.traderjoey.dao.impl;

import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.traderjoey.entity.User;
import com.traderjoey.dao.UserDAO;


//FIXME chen implemented

@Repository
public class UserDAOImpl implements UserDAO{
	
	// define field for entitymanager
	@Autowired
	private EntityManager entityManager;
		
	// set up constructor injection
	
	public UserDAOImpl() {
	}
    
	@Override
	public boolean add(User theUser) { 
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("FROM USER s WHERE s.name = :name");
		theQuery.setParameter("name", theUser.getName());
		if(theQuery.uniqueResult() != null) return false;
		theUser.setId(0);
        User flag = (User) session.save(theUser);
		return flag!=null;	
	}

	@Override
	public boolean isExist(String name) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("FROM USER s WHERE s.name = :name");
		theQuery.setParameter("name", name);
		if(theQuery.uniqueResult() == null) return false;
		return true;
	}

	@Override
	public User get(String name) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("FROM USER s WHERE s.name = :name");
		theQuery.setParameter("name", name);
		return (User) theQuery.uniqueResult();
	}

	@Override
	public User verify(String name, String password) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("FROM USER s WHERE s.name = :name AND s.password = :password");
		theQuery.setParameter("name", name);
        theQuery.setParameter("password", password);
        return (User) theQuery.uniqueResult();
	}
	

}
