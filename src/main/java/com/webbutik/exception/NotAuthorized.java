package com.webbutik.exception;

public class NotAuthorized  extends RuntimeException{

	public NotAuthorized(String message, Throwable cause) {
		super(message, cause);
		
	}

	public NotAuthorized(String message) {
		super(message);
	
	}

}
