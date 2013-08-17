package com.august.core.dao.impl;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.august.core.constants.PersistenceConstants;
import com.august.core.dao.GroupDao;
import com.august.core.domain.Group;

@Repository("groupDao")
public class GroupDaoImpl extends AbstractDaoImpl implements GroupDao {

	@Override
	public Group save(Group group) {

		group.setCreatedDate(new GregorianCalendar());
		group.setLastModifiedDate(new GregorianCalendar());

		return (Group) super.save(group);
	}

	@Override
	public void update(Group group) {

		group.setLastModifiedDate(new GregorianCalendar());
		super.update(group);
	}

	@Override
	public List<Group> getGroupsByUserEmail(String email) {
		@SuppressWarnings("unchecked")
		List<Group> groups = this.getSession()
				.createQuery(PersistenceConstants.FIND_GROUPS_BY_USER_EMAIL)
				.setString(0, email).list();

		return groups;
	}

	@Override
	public Group load(long uidPk) {
		return (Group) this.getSession().load(Group.class, uidPk);
	}
}
