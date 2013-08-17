package com.august.core.dao.impl;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import com.august.core.constants.PersistenceConstants;
import com.august.core.dao.UserDao;
import com.august.core.domain.User;
import com.august.core.exception.UserEmailExistException;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	public User save(User user) throws UserEmailExistException {
		if (isUserEmailExist(user.getEmail())) {
			throw new UserEmailExistException("User email already exist: "
					+ user.getEmail());
		}

		user.setCreatedDate(new GregorianCalendar());
		user.setLastModifiedDate(new GregorianCalendar());

		return (User) super.save(user);
	}

	public void update(User user) throws PersistenceException {
		if (user.getUidPk() == 0L) {
			throw new PersistenceException(
					"Object is not a persistence object");
		}

		user.setLastModifiedDate(new GregorianCalendar());

		super.update(user);
	}

	public User findUserByEmail(String email) throws PersistenceException {
		@SuppressWarnings("unchecked")
		List<User> users = this.getSession()
				.createQuery(PersistenceConstants.FIND_USER_BY_EMAIL)
				.setString(0, email).list();

		if (users.size() > 1) {
			throw new PersistenceException("Dulpicate users exist");
		}

		if (users.size() == 1) {
			User user = users.get(0);
			return user;
		}
		return null;
	}

	public List<User> findUsersByTripUid(long uidPk) {
		@SuppressWarnings("unchecked")
		List<User> users = this.getSession()
				.createQuery(PersistenceConstants.FIND_USER_BY_TRIP_UID)
				.setLong(0, uidPk).list();

		return users;
	}

	private boolean isUserEmailExist(String email) {
		@SuppressWarnings("unchecked")
		List<User> users = this.getSession()
				.createQuery(PersistenceConstants.FIND_USER_BY_EMAIL)
				.setString(0, email).list();

		if (users.size() > 0) {
			return true;
		}
		return false;
	}
}
