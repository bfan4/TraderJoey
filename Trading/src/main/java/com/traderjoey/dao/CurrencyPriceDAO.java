package com.traderjoey.dao;

import java.sql.Timestamp;
import java.util.List;

import com.traderjoey.bean.Currency;
import com.traderjoey.bean.CurrencyPrice;

public interface CurrencyPriceDAO {

	/**
	 * ����ʱʹ��,�����������ݿ�����һ���ж��ٸ��۸���Ŀ
	 * 
	 * @return
	 */
	public int getTotal();

	/**
	 * ����ʱʹ��,�����������ݿ�����ָ������һ���ж��ٸ��۸���Ŀ
	 * 
	 * @return
	 */
	public int getTotal(Currency currency);

	/**
	 * ��ѯָ�����ҵļ۸��б�,����ҳ��ʹ��,�ǳ���Ҫ
	 * 
	 * @param currency
	 * @return
	 */
	public List<CurrencyPrice> list(Currency currency);

	/**
	 * �г���ĳ��ʱ��֮ǰ��,ָ��������,ָ�����ҵļ۸�
	 * 
	 * @param currency
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CurrencyPrice> list(Currency currency, Timestamp end, int count);

	
	/**
	 * ������,����������һ��α���currency,ע��2��:
	 * 1.Ӧ�߱�timestamp���ع���,�����ظ�,���ǲ���console��������,˵�����ظ�
	 * 2.����Ҫ�����ݿ���ʵ��id����,���Դ�������idĬ��Ϊnull
	 * 3.����Ҫ������CurrencyPricesXXX�������,����Ҫ��Currency����������
	 * @param currency
	 */
	public void add(CurrencyPrice currencyPrice);
	
	
	/**
	 * ��ͬ����һ��,�˷�����һ�δ��������,������ʵ������ʱʹ��,���ݵ����Ӽ�googledocs,��ע��2��:
	 * 1.Ӧ�߱�timestamp���ع���,�����ظ�,���ǲ���console��������,˵�����ظ�
	 * 2.����Ҫ�����ݿ���ʵ��id����,���Դ�������idĬ��Ϊnull
	 * 3.���list������10֧����,����Ҫ����Ӧ��CurrencyPricesXXX���������һ��,����Ҫ��Currency����������
	 * @param list
	 */
	public void addAll(List<CurrencyPrice> list);
	
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
	public void delete(Timestamp end);
}
