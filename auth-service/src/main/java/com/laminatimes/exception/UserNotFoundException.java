package com.laminatimes.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
