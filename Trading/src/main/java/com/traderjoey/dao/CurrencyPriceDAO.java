package com.traderjoey.dao;

import java.sql.Timestamp;
import java.util.List;

import com.traderjoey.entity.Currency;
import com.traderjoey.entity.CurrencyPrice;

public interface CurrencyPriceDAO {

	/**
	 * ����ʱʹ��,�����������ݿ�����һ���ж��ٸ��۸���Ŀ
	 * 
	 * @return
	 */
	public long getTotal();

	/**
	 * ����ʱʹ��,�����������ݿ�����ָ������һ���ж��ٸ��۸���Ŀ
	 * @param currency id
	 * @return
	 */
	public long getTotal(int id);

	/**
	 * ��ѯָ�����ҵļ۸��б�,����ҳ��ʹ��,�ǳ���Ҫ
	 * 
	 * @param currency id
	 * @return
	 */
	public List<CurrencyPrice> getPriceList(int id);

	/**
	 * �г���ĳ��ʱ��֮ǰ��,ָ��������,ָ�����ҵļ۸�
	 * 
	 * @param currency id
	 * @param end
	 * @param count
	 * @return
	 */
	public List<CurrencyPrice> getPriceList(int id, Timestamp end, int count);

	
	/**
	 * ������,����������һ��α���currency,ע��2��:
	 * 1.Ӧ�߱�timestamp���ع���,�����ظ�,���ǲ���console��������,˵�����ظ�
	 * 2.����Ҫ�����ݿ���ʵ��id����,���Դ�������idĬ��Ϊnull
	 * 3.����Ҫ������CurrencyPricesXXX�������,����Ҫ��Currency����������currentPrice
	 * @param currency
	 * @throws Exception 
	 */
	public void addOrUpdate(CurrencyPrice currencyPrice) throws Exception;
	
	
	/**
	 * ��ͬ����һ��,�˷�����һ�δ��������,������ʵ������ʱʹ��,���ݵ����Ӽ�googledocs,��ע��2��:
	 * 1.Ӧ�߱�timestamp���ع���,�����ظ�,���ǲ���console��������,˵�����ظ�
	 * 2.����Ҫ�����ݿ���ʵ��id����,���Դ�������idĬ��Ϊnull
	 * 3.���list������10֧����,����Ҫ����Ӧ��CurrencyPricesXXX���������һ��,����Ҫ��Currency����������
	 * @param list
	 * @throws Exception 
	 */
	public void addOrUpdateAll(List<CurrencyPrice> list) throws Exception;
	
	/**
	 * ɾ��ָ�����ҵ����м۸��¼
	 * @param currency
	 */
	
	public void delete(Currency currency);

	/**
	 * ɾ����ĳ��ʱ��֮ǰ��,ָ�����ҵļ۸��¼
	 * @param end
	 * @param count
	 */
	public void delete(Currency currency, Timestamp end);
}
