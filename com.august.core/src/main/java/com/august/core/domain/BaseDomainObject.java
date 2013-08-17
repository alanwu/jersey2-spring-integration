package com.august.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public class BaseDomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2024249936609891210L;

	@Id
	@Column(name = "UIDPK")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_gen")
	@TableGenerator(name = "id_gen", table = "IDGENERATOR", pkColumnName = "PRIMARYKEY", valueColumnName = "VALUECOL", pkColumnValue = "PRIMARY_KEY_VALUE", initialValue = 100000, allocationSize = 1)
	private long uidPk;

	public long getUidPk() {
		return uidPk;
	}

	public void setUidPk(long uidPk) {
		this.uidPk = uidPk;
	}

}
