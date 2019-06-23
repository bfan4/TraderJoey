package com.traderjoey.dao;

import com.traderjoey.entity.Currency;
import com.traderjoey.bean.CurrencyPrice;
/**
 * FIXME chen
 * @author Gary
 *
 */
public interface CurrencyDAO {

	/**
	 * 
	 * @param currency
	 */
	public void add(Currency currency);

	public void delete(int id);

	public void updateCurrentPrice(int id, float currentPrice);

	public int getIdByName(String name);
	
	public Currency getCurrencyByName(String name);

}
