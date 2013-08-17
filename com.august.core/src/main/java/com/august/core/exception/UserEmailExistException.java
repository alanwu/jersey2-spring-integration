package com.august.core.exception;

public class UserEmailExistException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9043850085019582317L;

	public UserEmailExistException(String message) {
		super(message);
	}

	public UserEmailExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
