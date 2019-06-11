package com.traderjoey.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.traderjoey.dto.RequestUrl;
import com.traderjoey.utils.Key;

public class HttpGetServiceImplTest {

	@Test
	public void testHttpGetServiceImpl() throws Exception {
		HttpGetServiceImpl h = new HttpGetServiceImpl(
				new RequestUrl("https://api.nomics.com/v1/prices?key=" + Key.keyString));
		System.out.println(h.responseString);
		assertNotNull(h.responseString);
	}

}
