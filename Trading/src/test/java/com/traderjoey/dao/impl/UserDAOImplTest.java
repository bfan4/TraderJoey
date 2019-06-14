package com.traderjoey.dao.impl;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;


import com.traderjoey.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOImplTest {
	@Mock
	private EntityManager theEntityManager;
	@InjectMocks
	private UserDAOImpl userDAOImpl;

	@Test
	public void testGet() throws Exception {
		User newUser1 = new User("fan","admin");
		assertTrue(new UserDAOImpl().add(newUser1));
	}

}
