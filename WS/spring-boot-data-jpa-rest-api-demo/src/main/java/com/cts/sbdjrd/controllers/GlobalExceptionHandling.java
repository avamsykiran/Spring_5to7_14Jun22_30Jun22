package com.cts.sbdjrd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.sbdjrd.exception.AccountHolderNotFoundException;
import com.cts.sbdjrd.exception.InvalidAccountHolderException;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(AccountHolderNotFoundException.class)
	public ResponseEntity<String> handleAccountHolderNotFoundException(AccountHolderNotFoundException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidAccountHolderException.class)
	public ResponseEntity<String> handleInvalidAccountHolderException(AccountHolderNotFoundException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exp){
		exp.printStackTrace();
		return new ResponseEntity<String>("Unable to process your request please try again",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
