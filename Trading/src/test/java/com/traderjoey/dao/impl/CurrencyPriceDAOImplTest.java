package com.traderjoey.dao.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.traderjoey.entity.Currency;
import com.traderjoey.entity.CurrencyPrice;

public class CurrencyPriceDAOImplTest {
	
	CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
	CurrencyDAOImpl cdi = new CurrencyDAOImpl();

	Currency c1;
	Currency c2;
	Currency c3;

	CurrencyPrice cp1 = new CurrencyPrice();
	CurrencyPrice cp2 = new CurrencyPrice();
	CurrencyPrice cp3 = new CurrencyPrice();
	CurrencyPrice cp4 = new CurrencyPrice();
	CurrencyPrice cp5 = new CurrencyPrice();
	
	final String time1 = "2019-01-19 01:14:07";
	final String time2 = "2019-01-19 02:14:07";
	final String time3 = "2019-01-19 03:14:07";
	final String time4 = "2019-01-19 04:14:07";
	final String time5 = "2019-01-19 05:14:07";
	final String time6 = "2019-01-19 06:14:07";
	final String time7 = "2019-01-19 07:14:07";

    Timestamp myTimeStamp1;
	Timestamp myTimeStamp2;
	Timestamp myTimeStamp3;
	Timestamp myTimeStamp4;
	Timestamp myTimeStamp5;
	Timestamp myTimeStamp6;
	Timestamp myTimeStamp7;
	
	
public CurrencyPriceDAOImplTest() throws ParseException {
		super();
		//set my test time stamp
		this.myTimeStamp1 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time1).getTime());
		this.myTimeStamp2 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time2).getTime());
		this.myTimeStamp3 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time3).getTime());
		this.myTimeStamp4 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time4).getTime());
		this.myTimeStamp5 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time5).getTime());
		this.myTimeStamp6 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time6).getTime());
		this.myTimeStamp7 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time7).getTime());	
		
		c1 = cdi.getCurrencyByName("c1");
		c2 = cdi.getCurrencyByName("c2");
		c3 = cdi.getCurrencyByName("c3");
	}

	
	
	@Test
	public void testGetTotal() throws Exception {
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		System.out.println(cpdi.getTotal());
		assertEquals(0,cpdi.getTotal());
	}

	@Test
	public void testGetTotalInt() throws Exception {
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		assertEquals(1,cpdi.getTotal(1));
	}

	@Test
	public void testListInt() throws Exception {
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		System.out.println(cpdi.getPriceList(20));
	}

	@Test
	public void testAddOrUpdate() throws Exception {

		//set my test CurrencyPrice record

		cp1.setPrice(20.1f);
		cp1.setTimestamp(myTimeStamp2);
		cp1.setCurrency(c2);

		
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		System.out.println("strat CurrencyPriceDAO");
		
		cpdi.addOrUpdate(cp1);
	}
	

	@Test
	public void testGetPriceListIntTimestampInt() throws Exception {
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		List<CurrencyPrice> list = cpdi.getPriceList(1, myTimeStamp1, 4);
		for(CurrencyPrice cp : list) {
			System.out.println(cp.getTimestamp());
			System.out.println(cp.getCurrency().getId());
		}
	}

	@Test
	public void testGetPriceListInt() throws Exception {
		CurrencyPriceDAOImpl cpdi = new CurrencyPriceDAOImpl();
		List<CurrencyPrice> list = cpdi.getPriceList(20);
		for(CurrencyPrice cp : list) {
			System.out.println(cp.getTimestamp());
			System.out.println(cp.getPrice());
		}
	}



@Test
public void testDeleteCurrency() throws Exception {
	cpdi.delete(c2);
}


}
