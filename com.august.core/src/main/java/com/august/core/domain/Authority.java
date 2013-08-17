package com.august.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAUTHORITY")
public class Authority extends BaseDomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2834464405746612691L;

	@Column(name = "AUTHORITY", nullable = false)
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(final String authority) {
		this.authority = authority;
	}

}
