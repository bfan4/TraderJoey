package com.traderjoey.dao.impl;

import org.junit.Test;

import com.traderjoey.entity.Currency;

public class CurrencyDAOImplTest {
	Currency c1 = new Currency("c1");
	Currency c2 = new Currency("c2");
	Currency c3 = new Currency("c3");

	@Test
	public void testAdd1() throws Exception {
		System.out.println("hello add1");
		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
		cdi.add(c3);
	}
	
//	@Test
//	public void testAdd2() throws Exception {
//		System.out.println("hello add2");
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.add(c3);
//	}


//
//	@Test
//	public void testUpdateCurrentPrice() throws Exception {
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.updateCurrentPrice(20, 9);
//	}
//
//	@Test
//	public void testDelete() throws Exception {
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.delete(21);
//	}

//
//	@Test
//	public void testGetCurrencyByName() throws Exception {
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		Currency c = cdi.getCurrencyByName("c1");
//	}
//
//
//	@Test
//	public void testUpdateCurrentPrice() throws Exception {
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.updateCurrentPrice(20, 100);
//	}

}
