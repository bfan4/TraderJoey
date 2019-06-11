package com.traderjoey.dao;

import java.sql.Timestamp;
import java.util.List;

import com.traderjoey.bean.Currency;
import com.traderjoey.bean.CurrencyPrice;

public interface CurrencyPriceDAO {

	/**
	 * 调试时使用,看看现在数据库里面一共有多少个价格条目
	 * 
	 * @return
	 */
	public int getTotal();

	/**
	 * 调试时使用,看看现在数据库里面指定货币一共有多少个价格条目
	 * 
	 * @return
	 */
	public int getTotal(Currency currency);

	/**
	 * 查询指定货币的价格列表,交易页面使用,非常重要
	 * 
	 * @param currency
	 * @return
	 */
	public List<CurrencyPrice> list(Currency currency);

	/**
	 * 列出在某个时刻之前的,指定数量的,指定货币的价格
	 * 
	 * @param currency
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CurrencyPrice> list(Currency currency, Timestamp end, int count);

	
	/**
	 * 调试用,可用来插入一个伪造的currency,注意2点:
	 * 1.应具备timestamp查重功能,若有重复,覆盖并在console里面打出来,说明有重复
	 * 2.我们要在数据库上实现id自增,所以传过来的id默认为null
	 * 3.不仅要在它的CurrencyPricesXXX表里面插,而且要在Currency表上做更新
	 * @param currency
	 */
	public void add(CurrencyPrice currencyPrice);
	
	
	/**
	 * 不同于上一个,此方法是一次传多个进来,用于在实际运行时使用,数据的样子见googledocs,仍注意2点:
	 * 1.应具备timestamp查重功能,若有重复,覆盖并在console里面打出来,说明有重复
	 * 2.我们要在数据库上实现id自增,所以传过来的id默认为null
	 * 3.这个list里面是10支货币,不仅要在相应的CurrencyPricesXXX表里面各插一份,而且要在Currency表上做更新
	 * @param list
	 */
	public void addAll(List<CurrencyPrice> list);
	
	/**
	 * 删除指定货币的所有价格记录
	 * @param currency
	 */
	
	
	public void delete(Currency currency);

	/**
	 * 删除在某个时刻之前的,指定货币的价格记录
	 * @param end
	 * @param count
	 */
	public void delete(Timestamp end);
}
