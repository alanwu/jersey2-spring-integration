package com.august.core.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.august.core.AugustTestCase;
import com.august.core.dao.UserDao;
import com.august.core.domain.User;

public class UserDaoImplTest extends AugustTestCase {

	@Autowired
	UserDao userDao;

	User user = new User();

	@Before
	public void insertTestData() {
		user.setFirstName("Test_FirstName");
		user.setLastName("Test_LastName");
		user.setEmail("test@test.com");
		user.setPassword("test");

		userDao.save(user);

		userDao.update(user);
	}

	@Test
	public void testSaveNewUser() {
		User user = new User();
		user.setFirstName("Test_FirstName2");
		user.setLastName("Test_LastName2");
		user.setEmail("test2@test.com");
		user.setPassword("test2");

		userDao.save(user);

		assertNotSame(0L, user.getUidPk());
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setFirstName("Test_FirstName2");
		user.setLastName("Test_LastName2");
		user.setEmail("test2@test.com");
		user.setPassword("test2");

		userDao.save(user);

		user.setFirstName("Test_FirstName_Changed");

		userDao.update(user);

		assertEquals("Test_FirstName_Changed", user.getFirstName());
	}

	@Test
	public void testDelete() {
		User user = new User();
		user.setFirstName("Test_FirstName2");
		user.setLastName("Test_LastName2");
		user.setEmail("test2@test.com");
		user.setPassword("test2");

		userDao.delete(user);

		assertEquals(0, user.getUidPk());
	}

	@Test
	public void testFindUserByEmail() {
		User user = userDao.findUserByEmail("test@test.com");

		assertNotNull("User is null", user);
	}

	@Test
	public void testGetByUid() {
		User expected = (User) userDao.getByUid(new User(), user.getUidPk());

		assertNotNull("User doesn't exist", expected);
	}

}
