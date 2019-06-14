package com.traderjoey.dao.impl;

import org.junit.Test;

import com.traderjoey.bean.Currency;

import static org.junit.Assert.*;

import org.junit.Test;

public class CurrencyDAOImplTest {

	@Test
	public void testGet() throws Exception {
		System.out.println("hello");
		assertEquals(0, new CurrencyDAOImpl().get(new Currency()));
	}

}
