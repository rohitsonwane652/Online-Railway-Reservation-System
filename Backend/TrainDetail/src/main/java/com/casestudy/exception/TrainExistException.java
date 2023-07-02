package com.casestudy.exception;

public class TrainExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private long fieldValue;

	public TrainExistException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
