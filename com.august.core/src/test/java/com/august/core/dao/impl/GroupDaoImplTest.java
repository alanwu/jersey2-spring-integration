package com.august.core.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.august.core.AugustTestCase;
import com.august.core.dao.GroupDao;
import com.august.core.dao.UserDao;
import com.august.core.domain.Group;
import com.august.core.domain.User;

public class GroupDaoImplTest extends AugustTestCase {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GroupDao groupDao;
	
	@Before
	public void insertTestData() {
		User user = new User();
		user.setFirstName("Test_FirstName");
		user.setLastName("Test_LastName");
		user.setEmail("test@test.com");
		user.setPassword("test");

		userDao.save(user);
		
		Group group = new Group();
		group.setName("test group");
		
		groupDao.save(group);
		group.setName("test 2");
		user.getGroups().add(group);
		userDao.update(user);
	}
	
	@Test
	public void testSaveGroup() {
		Group group = new Group();
		group.setName("test group 1");
		
		groupDao.save(group);
		
		assertNotSame(0L, group.getUidPk());
	}

	@Test
	public void testUpdateGroup() {
		Group group = new Group();
		group.setName("test group");
		
		groupDao.save(group);
		
		group.setName("test gorup 2");
		groupDao.update(group);
		
		Group groupFromDb = groupDao.load(group.getUidPk());
		assertEquals("test gorup 2", groupFromDb.getName());
	}

	@Test
	public void testGetGroupsByUserEmail() {
		List<Group> groups = groupDao.getGroupsByUserEmail("test@test.com");
	
		assertEquals(1, groups.size());
	}

}
