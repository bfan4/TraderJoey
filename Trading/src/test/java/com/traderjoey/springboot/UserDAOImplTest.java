package com.traderjoey.springboot;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import com.traderjoey.bean.Currency;
import com.traderjoey.dao.impl.UserDAOImpl;
import com.traderjoey.entity.User;
import com.traderjoey.springConf.AppConf;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {AppConf.class})
public class UserDAOImplTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	private User newUser1 = new User("Andy", "000000");

	
//	@Test
//	public void testGet() throws Exception {
//		//User newUser2 = userDAOImpl.get("Andy");
//		//assertEquals(null, userDAOImpl.get("Andy"));
//		assertNull(userDAOImpl.get("Andy"));
//	}

	@Test
	public void testAdd() throws Exception {
		entityManager.persist(newUser1);
		entityManager.flush();
		
		assertEquals(true, userDAOImpl.add(newUser1));
	}

}
