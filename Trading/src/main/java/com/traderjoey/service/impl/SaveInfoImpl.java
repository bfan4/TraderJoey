package com.traderjoey.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traderjoey.bean.CurrencyPrice;
import com.traderjoey.dto.RequestUrl;
import com.traderjoey.exception.EmptyHttpResponseException;
import com.traderjoey.utils.Key;
import com.traderjoey.utils.Symbol;

public class SaveInfoImpl extends HttpGetServiceImpl {

	public SaveInfoImpl() throws IOException {
		super(new RequestUrl("https://api.nomics.com/v1/prices?key=" + Key.keyString));

	}

	public void insertInfo() throws EmptyHttpResponseException, JsonParseException, JsonMappingException, IOException {
		if (!StringUtils.isBlank(responseString)) {
			ObjectMapper mapper = new ObjectMapper();
			CurrencyPrice[] currencyPrices = mapper.readValue(responseString, CurrencyPrice[].class);
			System.out.println(currencyPrices[0]);
			System.out.println(currencyPrices[1]);
			for (CurrencyPrice currencyPrice : currencyPrices) {
				
			}
			for (Symbol symbol : Symbol.values()) {

			}

		} else {
			throw new EmptyHttpResponseException();
		}
	}

}
