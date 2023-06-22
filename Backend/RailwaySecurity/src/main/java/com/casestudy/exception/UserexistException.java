package com.casestudy.exception;

public class UserexistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String userEmail;

	public UserexistException(String message,String userEmail) {
		super(String.format("%s : %s", message, userEmail));
		this.message = message;
		this.userEmail = userEmail;
	}
}
