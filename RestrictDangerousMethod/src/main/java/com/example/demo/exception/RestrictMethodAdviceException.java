package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestrictMethodAdviceException {
	
	String ERR_RESPONSE = "FAILURE";

	@ExceptionHandler(ClassCastException.class)
	public ResponseEntity<?> handleRateException(ClassCastException ex) {
		List<String> list = new ArrayList<String>();
		list.add(ex.getMessage());
		ExceptionResponse response = new ExceptionResponse(ERR_RESPONSE, ex.getMessage(), "",
				LocalDateTime.now(), list);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}
	

	@ExceptionHandler(RestrictMethodException.class)
	public ResponseEntity<?> handleRateException(RestrictMethodException ex) {
		List<String> list = new ArrayList<String>();
		list.add(ex.getMessage());
		ExceptionResponse response = new ExceptionResponse(ERR_RESPONSE, ex.getMessage(), "",
				LocalDateTime.now(), list);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}

}