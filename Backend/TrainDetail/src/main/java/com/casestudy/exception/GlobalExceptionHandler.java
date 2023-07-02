package com.casestudy.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundExceptionHandler(TrainNotFoundException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrainExistException.class)
	public ResponseEntity<String> trainExistExceptionHandler(TrainExistException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrainJourneyExistException.class)
	public ResponseEntity<String> trainJourneyExistHandler(TrainJourneyExistException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
}
