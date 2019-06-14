package com.traderjoey.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.traderjoey.entity.User;
import com.traderjoey.dao.UserDAO;


//FIXME chen implemented

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	@Override
	public boolean add(User theUser) {
		if(isExist(theUser.getName())) return false;
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theUser);
		return true;		
	}

	@Override
	public boolean isExist(String name) {
		if(this.get(name) == null) return true;
		return false;
	}

	@Override
	public User get(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM USER s WHERE s.name = :name");
        query.setParameter("name", name);
		return (User) query.uniqueResult();
	}

	@Override
	public User verify(String name, String password) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM USER s WHERE s.name = :name AND s.password = :password");
        query.setParameter("name", name);
        query.setParameter("password", password);
		return (User) query.uniqueResult();
	}
	

}
