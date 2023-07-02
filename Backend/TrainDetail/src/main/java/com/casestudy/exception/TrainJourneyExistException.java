package com.casestudy.exception;

public class TrainJourneyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String message;

	public TrainJourneyExistException(String message) {
		super(message);
		this.message = message;
	}
	
	
}
