package com.traderjoey.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.traderjoey.entity.User;
import com.traderjoey.dao.UserDAO;

//FIXME chen
public class UserDAOImpl implements UserDAO{
	
	@Override
	public boolean add(User theUser) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// reset ID
			theUser.setId(0);
			System.out.println(theUser);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving User");
			session.save(theUser);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			factory.close();
		}
	}

	@Override
	public boolean isExist(String name) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			System.out.println("looking for " + name);			
			// start a transaction
			session.beginTransaction();
			
			// query
			String hql = "FROM User u WHERE u.name = :name";
			Query<User> query = session.createQuery(hql);
			query.setParameter("name", name);
			User theUser = (User)query.uniqueResult();
			
			// commit transaction
			session.getTransaction().commit();
			
			if(theUser != null) return true;
			return false;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			factory.close();
		}
	}

	@Override
	public User get(String name) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			System.out.println("looking for " + name);			
			// start a transaction
			session.beginTransaction();
			
			// query
			String hql = "FROM User U WHERE U.name = :name";
			Query<User> query = session.createQuery(hql);
			query.setParameter("name", name);
			User theUser = query.uniqueResult();
			
			// commit transaction
			session.getTransaction().commit();
			
			return theUser;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			factory.close();
		}
	}

	@Override
	public User verify(String name, String password) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			System.out.println("looking for " + name);			
			// start a transaction
			session.beginTransaction();
			
			// query
			String hql = "FROM User U WHERE U.name = :name AND u.password";
			Query<User> query = session.createQuery(hql);
			query.setParameter(0, name);
			query.setParameter(1,password);
			User theUser = query.uniqueResult();
			
			// commit transaction
			session.getTransaction().commit();
			return theUser;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			factory.close();
		}
	}

}
