package com.traderjoey.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.traderjoey.entity.Currency;
import com.traderjoey.utils.Symbol;

public class CurrencyDAOImplTest {
//
//	Currency c1 = new Currency("BTC");
//	Currency c2 = new Currency("LTC");
//	Currency c3 = new Currency("ETH");
//	Currency c4 = new Currency("ZEC");
//	Currency c5 = new Currency("DASH");
//	Currency c6 = new Currency("XMR");
//	Currency c7 = new Currency("BCH");
//	Currency c8 = new Currency("NEO");
//	Currency c9 = new Currency("EOS");
//	Currency c10 = new Currency("PETH");


	@Test
	public void testAdd1() throws Exception {
		System.out.println("hello add1");
		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
		for(Symbol symbol : Symbol.values()) {
			cdi.add(new Currency(symbol.toString()));
		}
		

	}
	
//	@Test
//	public void testAdd2() throws Exception {
//		System.out.println("hello add2");
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.add(c3);
//	}



//	@Test
//	public void testDelete() throws Exception {
//		CurrencyDAOImpl cdi = new CurrencyDAOImpl();
//		cdi.delete(21);
//	}
//
//
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
//		cdi.updateCurrentPrice(1, 100);
//	}


}
