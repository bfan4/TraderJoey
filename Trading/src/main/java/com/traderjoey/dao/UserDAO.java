package com.traderjoey.dao;

import com.traderjoey.bean.User;

public interface UserDAO {
	/**
	 * 给前端注册对象时使用,返回一个boolean给前端判断注册是否成功,true为成功,false为不成功/账号已存在
	 * 在这里不要忘记设置初始balance为100,000刀
	 * @param bean
	 */
	public boolean add(User bean);

	/**
	 * 给前端判断用户是否已经存在的操作
	 * @param name
	 * @return
	 */
	public boolean isExist(String name);

	/**
	 * 给前端获取用户对象的操作
	 * @param name
	 * @return
	 */
	public User get(String name);

	/**
	 * 给前端获取用户对象的合理方式
	 * @param name
	 * @param password
	 * @return
	 */
	public User get(String name, String password);

}
