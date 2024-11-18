package com.cts.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorRespose> handleEmployeeNotFoundException(EmployeeNotFoundException e){
		ErrorRespose errorRespose=new ErrorRespose(new Date(), e.getMessage(), HttpStatus.NOT_FOUND);		
		return new ResponseEntity<>(errorRespose, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorRespose> handleExction(Exception e){
		ErrorRespose errorRespose=new ErrorRespose(new Date(), e.getMessage(), HttpStatus.NOT_FOUND);		
		return new ResponseEntity<>(errorRespose, HttpStatus.NOT_FOUND);
	}
}
