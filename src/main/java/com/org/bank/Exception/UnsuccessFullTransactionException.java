package com.org.bank.Exception;

public class UnsuccessFullTransactionException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public UnsuccessFullTransactionException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
