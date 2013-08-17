package com.august.core.service;

import java.util.List;

import com.august.core.domain.Group;
import com.august.core.domain.User;
import com.august.core.exception.UserEmailExistException;


public interface UserService extends AbstractService {

	public User addUser(User user) throws UserEmailExistException;

	public void updateUser(User user);

	public void addUserToGroup(User user, Group group);
	
	public User findUserByEmail(String email);
	
	public List<User> findUsersByTripUid(long uidPk);
	
	public Group addGroup(Group group);
	
}
