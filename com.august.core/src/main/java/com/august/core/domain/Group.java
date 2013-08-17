package com.august.core.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TGROUP")
public class Group extends BaseDomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6721790105041341736L;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@ManyToMany(mappedBy="groups")
	private Set<User> users;

	@Column(name = "CREATED_DATE")
	private Calendar createdDate;

	@Column(name = "LAST_MODIFIED_DATE")
	private Calendar lastModifiedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		if (this.users == null) {
			users = new HashSet<User> ();
		}
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Calendar lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
