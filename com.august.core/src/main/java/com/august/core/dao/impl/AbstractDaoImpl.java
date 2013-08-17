package com.august.core.dao.impl;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.august.core.dao.AbstractDao;
import com.august.core.domain.BaseDomainObject;

public abstract class AbstractDaoImpl implements AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public BaseDomainObject save(BaseDomainObject domain)
			throws PersistenceException {
		try {
			this.getSession().save(domain);
			return domain;
		} catch (HibernateException he) {
			throw new PersistenceException(he.getMessage());
		}
	}

	public void update(BaseDomainObject domain) throws PersistenceException {
		if (domain.getUidPk() == 0L) {
			throw new PersistenceException("Not a persistence object");
		}

		this.getSession().update(domain);
	}

	public BaseDomainObject saveOrUpdate(BaseDomainObject domain)
			throws PersistenceException {
		this.getSession().saveOrUpdate(domain);

		return domain;
	}

	public void delete(BaseDomainObject domain) throws PersistenceException {
		this.getSession().delete(domain);
	}

	public BaseDomainObject getByUid(BaseDomainObject domain, long uidPk)
			throws PersistenceException {
		if (uidPk == 0L) {
			throw new PersistenceException("Not a valid uidPk");
		}

		return (BaseDomainObject) this.getSession().get(domain.getClass(),
				uidPk);
	}

}
