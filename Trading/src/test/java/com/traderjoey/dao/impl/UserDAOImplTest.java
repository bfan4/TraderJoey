package com.traderjoey.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.traderjoey.entity.User;

public class UserDAOImplTest {

	User user1 = new User("one", "one");
	User user2 = new User("two", "two");
	User user3 = new User("three", "three");
	User user4 = new User("four", "four");
	User user5 = new User("five", "five");
	User user6 = new User("six", "six");
	
	
	
//	@Test
//	public void testAdd() throws Exception {
//		assertTrue(new UserDAOImpl().add(user1));
//	}
	
	@Test
	public void testGet() throws Exception {
		assertTrue(new UserDAOImpl().isExist("one"));
	}
}
