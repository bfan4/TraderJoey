package com.traderjoey.dao.impl;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.traderjoey.entity.User;
import com.traderjoey.dao.UserDAO;
import org.springframework.transaction.annotation.Transactional;


//FIXME chen implemented

@Repository
public class UserDAOImpl implements UserDAO{
	
    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
	   entityManager = theEntityManager;
    }
    
	@Override
	@Transactional
	public boolean add(User theUser) {
		if(this.isExist(theUser.getName())) return false;
		
		Session currentSession = entityManager.unwrap(Session.class);
		int record = (int) currentSession.save(theUser);		
		if(record != 0) return true;		
		return false;		
	}

	@Override
	@Transactional
	public boolean isExist(String name) {
		if(this.get(name) == null) return true;
		return false;
	}

	@Override
	@Transactional
	public User get(String name) {
		Session currentSession = entityManager.unwrap(Session.class);
		Criteria criteria = currentSession.createCriteria(User.class);
		User theUser = (User) criteria.add(Restrictions.eq("name", name)).uniqueResult();
		return theUser;
	}

	@Override
	@Transactional
	public User get(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
