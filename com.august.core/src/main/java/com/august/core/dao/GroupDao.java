package com.august.core.dao;

import java.util.List;

import com.august.core.domain.Group;

public interface GroupDao extends AbstractDao {

	public Group save(Group group) ;

	public void update(Group group) ;
	
	public List<Group> getGroupsByUserEmail(String email);
	
	public Group load(long uidPk);
	
}
