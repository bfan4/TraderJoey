package com.traderjoey.dao.impl;

import com.traderjoey.entity.Currency;
import com.traderjoey.entity.CurrencyPrice;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.traderjoey.dao.CurrencyDAO;

//FIXME Chen done
public class CurrencyDAOImpl implements CurrencyDAO{
	// create session factory
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Currency.class)
							.addAnnotatedClass(CurrencyPrice.class)
							.buildSessionFactory();
	// create session
	@Override
	public void add(Currency currency) {
		
		Session session = factory.openSession();
		
		try {			
			// reset ID
			currency.setId(0);
			System.out.println("saving " + currency.getName());
			
			// start a transaction
			session.beginTransaction();
			
			// save the currency object
			session.save(currency);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		
	}

	@Override
	public void delete(int id) {
		
		// create session
		Session session = factory.openSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			//find the currency
			Currency theCurrency = session.get(Currency.class, id);
			
			// delete the instructors
			if (theCurrency != null) {
			
				System.out.println("Deleting: " + theCurrency);
				
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL
				//
				session.delete(theCurrency);				
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
		}
	}

	@Override
	public void updateCurrentPrice(int id, float currentPrice) {

		// create session
		Session session = factory.openSession();
		
		try {														
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update currency information
			System.out.println("Updating currency information ");
			Currency theCurrency = (Currency) session.get(Currency.class, id);
			theCurrency.setCurrentPrice(currentPrice);
						
			// commit the transaction
			session.getTransaction().commit();

			
			System.out.println("Done!");
		}
		finally {
			session.close();
		}
	}

	@Override
	public int getIdByName(String name) {
		int id = 0;
		
		// create session
		Session session = factory.openSession();
		try {														
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update currency information
			System.out.println("looking for currency id ");
			String queryString = "FROM Currency WHERE name = :name";
			Query query = session.createQuery(queryString);
			query.setParameter("name", name);
			Currency theCurrency = (Currency) query.uniqueResult();
			session.getTransaction().commit();
			id = theCurrency.getId();
		
			System.out.println("The id is: " + id);
		}
		finally {
			session.close();
		}
		
		return id;
	}

	@Override
	public Currency getCurrencyByName(String name) {
		Currency theCurrency;

		// create session
		Session session = factory.openSession();
		try {														
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// looking for currency
			System.out.println("looking for currency");
			String queryString = "FROM Currency WHERE name = :name";
			Query query = session.createQuery(queryString);
			query.setParameter("name", name);
			theCurrency = (Currency) query.uniqueResult();
			session.getTransaction().commit();		
			System.out.println(theCurrency.getId());
			return theCurrency;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		finally {
			session.close();
		}	
	}

}
