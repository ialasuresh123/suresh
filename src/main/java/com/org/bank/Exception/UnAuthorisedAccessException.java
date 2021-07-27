package com.org.bank.Exception;

public class UnAuthorisedAccessException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public UnAuthorisedAccessException(String message) {
		super();
		this.message = message;
	}
	
	
}
