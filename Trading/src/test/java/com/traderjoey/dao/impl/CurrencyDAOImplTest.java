package com.traderjoey.dao.impl;

import org.junit.Test;

import com.traderjoey.entity.Currency;

public class CurrencyDAOImplTest {
	Currency c1 = new Currency("c1");
	Currency c2 = new Currency("c2");
	Currency c3 = new Currency("c3");

//	@Test
//	public void testAdd1() throws Exception {
//		System.out.println("hello1");
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.add(c2);
//	}



	@Test
	public void testUpdateCurrentPrice() throws Exception {
		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
		cdi.updateCurrentPrice(20, 9);
	}

	@Test
	public void testDelete() throws Exception {
		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
		cdi.delete(21);
	}

//	@Test
//	public void testGetIdByName() throws Exception {
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		int id = cdi.getIdByName("c1");
//		System.out.println(id);
//	}


}
