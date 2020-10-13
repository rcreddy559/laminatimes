package com.laminatimes.exception;

public class UserNotFoundRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundRuntimeException(String userName) {
		super("User Name not found : " + userName);
	}

}
