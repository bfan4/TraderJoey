package com.traderjoey.dao.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.traderjoey.entity.Currency;
import com.traderjoey.entity.CurrencyPrice;

public class CurrencyPriceDAOImplTest {

	Currency c1;
	Currency c2;


	
	CurrencyPrice cp1 = new CurrencyPrice();
	CurrencyPrice cp2 = new CurrencyPrice();
	CurrencyPrice cp3 = new CurrencyPrice();
	CurrencyPrice cp4 = new CurrencyPrice();
	CurrencyPrice cp5 = new CurrencyPrice();
	
//	
//	
//	@Test
//	public void testGetTotal() throws Exception {
//		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
//		System.out.println(cpdi.getTotal());
//		assertEquals(4,cpdi.getTotal());
//	}
//
//	@Test
//	public void testGetTotalInt() throws Exception {
//		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
//		assertEquals(2,cpdi.getTotal(20));
//	}
//
//	@Test
//	public void testListInt() throws Exception {
//		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
//		System.out.println(cpdi.getPriceList(20));
//	}

	@Test
	public void testAddOrUpdate() throws Exception {
		//set my test time stamp
		Date lFromDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-01-19 18:14:07");
		Timestamp myTimeStamp = new Timestamp(lFromDate.getTime());
		
		//set my test currency 
		c1 = new CurrencyDAOImpl().getCurrencyByName("c1");
		System.out.println("test id is: " + c1.getId());
		
		cp1.setPrice(202);
		cp1.setTimestamp(myTimeStamp);
		cp1.setCurrency(c1);

		
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		System.out.println("strat CurrencyPriceDAO");
		
		cpdi.addOrUpdate(cp1);
	}

//	@Test
//	public void testGetPriceListInt() throws Exception {
//		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
//		List<CurrencyPrice> list = cpdi.getPriceList(20);
//		for(CurrencyPrice cp : list) {
//			System.out.println(cp);
//		}
//	}

}
