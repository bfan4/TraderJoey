package com.traderjoey.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.traderjoey.entity.Currency;
import com.traderjoey.entity.CurrencyPrice;
import com.traderjoey.dao.impl.CurrencyDAOImpl;
import com.traderjoey.dao.impl.CurrencyPriceDAOImpl;
import com.traderjoey.dto.RequestUrl;
import com.traderjoey.exception.EmptyHttpResponseException;
import com.traderjoey.utils.Key;
import com.traderjoey.utils.Symbol;

public class SaveInfoImpl extends HttpGetServiceImpl {

	public SaveInfoImpl() throws IOException {
		super(new RequestUrl("https://api.nomics.com/v1/prices?key=" + Key.keyString));
	}

	public void insertInfo() throws Exception {
		if (!StringUtils.isBlank(responseString)) {
			ObjectMapper mapper = new ObjectMapper();

			List<CurrencyPrice> cpList = new ArrayList();
			List<String> nameList = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(responseString);
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.optString("currency");
                nameList.add(name);
            }

			// currencyPrice.currency is an object rather than a String
			CurrencyPrice[] currencyPrices = mapper.readValue(responseString, CurrencyPrice[].class);
			int count = 0;
			for(int i =0; i < currencyPrices.length; i++) {
				for(Symbol symbol : Symbol.values()) {
					if(nameList.get(i).equalsIgnoreCase(symbol.toString())) {
						currencyPrices[i].setCurrency(new CurrencyDAOImpl().getCurrencyByName(nameList.get(i)));
						currencyPrices[i].setTimestamp(new Timestamp(System.currentTimeMillis()));
						System.out.println(currencyPrices[i]);
						cpList.add(currencyPrices[i]);
						new CurrencyPriceDAOImpl().addOrUpdate(currencyPrices[i]);
						count++;
					}
				}
			}

			System.out.println("************Totally Updated "+ count +" Currencys*************");
		} else {
			throw new EmptyHttpResponseException();
		}
	}
}
