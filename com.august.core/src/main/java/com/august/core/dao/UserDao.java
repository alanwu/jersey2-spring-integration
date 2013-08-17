package com.august.core.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.august.core.domain.User;
import com.august.core.exception.UserEmailExistException;

public interface UserDao extends AbstractDao {

	public User save(User user) throws UserEmailExistException;

	public void update(User user) throws PersistenceException;

	public User findUserByEmail(String email) throws PersistenceException;

	public List<User> findUsersByTripUid(long uidPk);
	
}
