package com.org.bank.Exception;

public class UserDetailsNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public UserDetailsNotFoundException(String message) {
		super();
		this.message = message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
