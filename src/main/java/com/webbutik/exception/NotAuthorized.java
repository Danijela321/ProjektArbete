package com.webbutik.exception;

/**
 * Ta hand om exception pgv authorisation
 * @author Danijela
 *
 */
public class NotAuthorized  extends RuntimeException{

	/**
	 * Konstruktor fran Superklass
	 * @param message Skickar meddelande till anvandare
	 * @param cause not authorized
	 */
	public NotAuthorized(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	/**
	 * Konstruktor fran Superklass
	 * @param message Skickar meddelande till anvandare
	 * 
	 */
	public NotAuthorized(String message) {
		super(message);
	
	}

}
