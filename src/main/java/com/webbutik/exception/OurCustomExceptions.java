package com.webbutik.exception;

public class OurCustomExceptions extends RuntimeException{

	public OurCustomExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}

	public OurCustomExceptions(String message) {
		super(message);
	
	}

}
