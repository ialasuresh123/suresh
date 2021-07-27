package com.org.bank.Exception;

public class InsufficientBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public InsufficientBalanceException(String message) {
		super();
		this.message = message;
	}

}
