package com.august.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.august.core.dao.GroupDao;
import com.august.core.dao.UserDao;
import com.august.core.domain.Group;
import com.august.core.domain.User;
import com.august.core.exception.UserEmailExistException;
import com.august.core.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private GroupDao groupDao;
	
	public User addUser(User user) throws UserEmailExistException {
		return this.userDao.save(user);
	}

	public void updateUser(User user) {
		this.userDao.update(user);
	}

	public User findUserByEmail(String email) {
		return this.userDao.findUserByEmail(email);
	}
	
	public List<User> findUsersByTripUid(long uidPk) {
		return this.userDao.findUsersByTripUid(uidPk);
	}

	@Override
	public void addUserToGroup(User user, Group group) {
		user.getGroups().add(group);
		this.userDao.update(user);
	}
	
	public Group addGroup(Group group) {
		return this.groupDao.save(group);
	}
	
}
