package com.traderjoey.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.traderjoey.entity.Currency;
import com.traderjoey.entity.CurrencyPrice;
import com.traderjoey.dao.CurrencyPriceDAO;

//FIXME Chen implemented
public class CurrencyPriceDAOImpl implements CurrencyPriceDAO{
	
	// create session factory
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Currency.class)
							.addAnnotatedClass(CurrencyPrice.class)
							.buildSessionFactory();

	@Override
	public long getTotal() {
		long total = -1;

		// create session
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			String queryString = "select count(*) from CurrencyPrice currency_price";
			Query query = session.createQuery(queryString);
			total = (long) query.uniqueResult();
	        session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return total;
	}

	@Override
	public long getTotal(int id) {
		long total = -1;

		// create session
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			String queryString = "SELECT COUNT(*) FROM CurrencyPrice currency_price WHERE currency_id = :id";
			Query query = session.createQuery(queryString);
			query.setParameter("id", id);
			total = (long) query.uniqueResult();
			System.out.println(total);
	        session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return total;
	}
	
	@Override
	public List<CurrencyPrice> getPriceList(int id) {
		List<CurrencyPrice> list = new ArrayList<>();

		// create session
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			String queryString = "FROM CurrencyPrice currency_price WHERE currency_id = :id";
			Query query = session.createQuery(queryString);
			query.setParameter("id", id);
			list = query.list();
			System.out.println(list);
	        session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}		
		return list;
	}

	@Override
	public List<CurrencyPrice> getPriceList(int id, Timestamp end, int count) {
		List<CurrencyPrice> list = new ArrayList<>();

		// create session
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			String queryString = "FROM CurrencyPrice currency_price WHERE currency_id = :id ORDER BY time_stamp DESC";
			Query query = session.createQuery(queryString);
			query.setParameter("id", id);
			list = query.list();
			System.out.println(list);
	        session.getTransaction().commit();
	        while(list.size()>count) {
	        	list.remove(list.size()-1);
	        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}		
		return list;
	}

	public Timestamp getCurrencyLatestTimestamp(int id) throws Exception {
		Session session = factory.openSession();
		//define the earliest time stamp in mysql
		Date lFromDate1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1000-01-01 00:00:00");
		Timestamp latest = new Timestamp(lFromDate1.getTime());
		
		try{
			System.out.println("looking for the latest time");
			String queryString = "FROM CurrencyPrice cp WHERE currency_id = :id ORDER BY time_stamp DESC";
			Query query = session.createQuery(queryString);
			query.setParameter("id", id);
			latest = ((CurrencyPrice) query.list().get(0)).getTimestamp();
			System.out.println("latest time is " + latest);
		}
		catch(Exception e) {
			System.out.println(e);
			}
		finally {
			session.close();
		}
		return latest;
	}
	
	@Override
	public void addOrUpdate(CurrencyPrice currencyPrice) throws Exception {

		// create session
		Timestamp latest = this.getCurrencyLatestTimestamp(currencyPrice.getCurrency().getId());
		System.out.println("my latest: " + latest);
		Session session = factory.openSession();

		try {		
			// reset ID
			currencyPrice.setRecord(0);
			System.out.println("saving new currencyPrice");
			
			// start a transaction
			session.beginTransaction();
			//get the latest currency price record. Update it if needed
			String queryString = "FROM CurrencyPrice WHERE currency_id = :id AND time_stamp = :time_stamp";
			Query query = session.createQuery(queryString);
			query.setParameter("id", currencyPrice.getCurrency().getId());
			query.setParameter("time_stamp", currencyPrice.getTimestamp());
			CurrencyPrice theCurrencyPrice = (CurrencyPrice) query.uniqueResult();
			System.out.println(theCurrencyPrice);
			
			if(theCurrencyPrice != null) {
				System.out.println("Updating exist record");
				theCurrencyPrice.setPrice(currencyPrice.getPrice());
				// commit transaction
				session.getTransaction().commit();
				System.out.println("Update exist record, id = " + currencyPrice.getCurrency().getId() + " time: " + currencyPrice.getTimestamp() );
			}
			else {
				session.save(currencyPrice);
				// commit transaction
				session.getTransaction().commit();
				System.out.println("Saved record: id = " + currencyPrice.getCurrency().getId() + " and price=" + currencyPrice.getPrice());
			}

			if(currencyPrice.getTimestamp().after(latest)) {
				new CurrencyDAOImpl().updateCurrentPrice(currencyPrice.getCurrency().getId(), currencyPrice.getPrice());
				System.out.println("Update currency price: id=" + currencyPrice.getCurrency().getId() + " and price=" + currencyPrice.getPrice() );
			}

			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			if(session != null)
			session.close();
		}
			
	}

	@Override
	public void delete(Currency currency) {
		// create session
		Session session = factory.openSession();
		try {			
			System.out.println("deleting all currencyPrice of " + currency.getId());
			
			// start a transaction
			session.beginTransaction();
			String queryString = "FROM CurrencyPrice cp WHERE currency_id = :id";
			Query query = session.createQuery(queryString);
			query.setParameter("id", currency.getId());
			List<CurrencyPrice> list = query.list();
			for(CurrencyPrice currencyPrice : list) {
				session.delete(currencyPrice);
			}
			session.getTransaction().commit();
			System.out.println("Deleted");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(Currency currency, Timestamp end) {
		// create session
		Session session = factory.openSession();
		try {			
			System.out.println("deleting all currencyPrice of " + currency.getId() + "and before " + end);
			
			// start a transaction
			session.beginTransaction();
			String queryString = "FROM CurrencyPrice cp WHERE currency_id = :id AND time_stamp < :time_stamp";
			Query query = session.createQuery(queryString);
			query.setParameter("id", currency.getId());
			query.setParameter("time_stamp", end);			
			List<CurrencyPrice> list = query.list();
			int count = 0;
			for(CurrencyPrice currencyPrice : list) {
				session.delete(currencyPrice);
				count++;
			}
			session.getTransaction().commit();
			System.out.println("Deleted " + count +"records");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
	}

	@Override
	public void addAll(List<CurrencyPrice> list) {
		for(CurrencyPrice currencyPrice : list) {
			Session session = factory.openSession();
			try {			
				// reset ID
				currencyPrice.setRecord(0);
				System.out.println("saving new currencyPrice");
				
				// start a transaction
				session.beginTransaction();
	
				//get the latest currency price record. Update it if needed
				String queryString = "FROM CurrencyPrice cp WHERE currency_id = :id AND time_stamp = :time_stamp";
				Query query = session.createQuery(queryString);
				query.setParameter("id", currencyPrice.getCurrency().getId());
				query.setParameter("time_stamp", currencyPrice.getTimestamp());
				CurrencyPrice theCurrencyPrice = (CurrencyPrice) query.uniqueResult();
				System.out.println(theCurrencyPrice);
	
				if(theCurrencyPrice != null) {
					theCurrencyPrice.setPrice(currencyPrice.getPrice());
					session.getTransaction().commit();
					System.out.println("update exist record, id = " + currencyPrice.getCurrency().getId() + " time: " + currencyPrice.getTimestamp() );
					return;
				}
				session.save(currencyPrice);
				
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
	}


}
