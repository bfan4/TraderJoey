package com.traderjoey.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.traderjoey.entity.User;

public class UserDAOImplTest {

	User user1 = new User("one", "one");
	User user1_1 = new User("one", "one");
	User user2 = new User("two", "two");
	User user3 = new User("three", "three");
	User user4 = new User("four", "four");
	User user5 = new User("five", "five");
	User user6 = new User("six", "six");
	UserDAOImpl up =  new UserDAOImpl();
	
	
	@Test
	public void testAdd() throws Exception {
		assertTrue(up.add(user3));
	}
//	
//	@Test
//	public void testIsExist() throws Exception {
//		assertTrue(new UserDAOImpl().isExist("one"));
//	}
	
	@Test
	public void testVerify() throws Exception {
		user1_1.setId(1);
		assertEquals(user1,new UserDAOImpl().verify("two","two"));
	}	
	
}
