package com.traderjoey.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traderjoey.bean.CurrencyPrice;

import com.traderjoey.dao.impl.CurrencyPricesDAOImpl;
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
			for (CurrencyPrice currencyPrice : currencyPrices) {
				currencyPrice.setTimestamp(new Timestamp(System.currentTimeMillis()));
			}

			List<CurrencyPrice> list = new ArrayList<CurrencyPrice>();
			for (Symbol symbol : Symbol.values()) {
				for (int i = 0; i < currencyPrices.length; i++) {
					if (currencyPrices[i].getCurrency().equals(symbol.toString())) {
						list.add(currencyPrices[i]);
					}
				}
			}
			new CurrencyPricesDAOImpl().addAll(list);

		} else {
			throw new EmptyHttpResponseException();
		}
	}

}
