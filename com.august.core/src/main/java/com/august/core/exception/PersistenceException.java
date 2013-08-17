package com.august.core.exception;

public class PersistenceException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8668134874580775816L;

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
