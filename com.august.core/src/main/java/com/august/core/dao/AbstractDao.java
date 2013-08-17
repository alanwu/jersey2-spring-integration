package com.august.core.dao;

import javax.persistence.PersistenceException;

import com.august.core.domain.BaseDomainObject;

public interface AbstractDao {
	
	public void delete(BaseDomainObject domain) throws PersistenceException;

	public BaseDomainObject getByUid(BaseDomainObject domain, long uidPk)
			throws PersistenceException;
	
}
