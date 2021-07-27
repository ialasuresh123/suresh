package com.org.bank.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<ErrorResponse> userDetailsNotFoundException(UserDetailsNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(UnAuthorisedAccessException.class)
	public ResponseEntity<ErrorResponse> unAuthorisedAccessException (UnAuthorisedAccessException ex) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);

	}



	@ExceptionHandler(UnsuccessFullTransactionException.class)
	public ResponseEntity<ErrorResponse> unsuccessFullTransactionException(UnsuccessFullTransactionException ex) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> insufficientBalanceException(InsufficientBalanceException ex) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);

	}
	
}
