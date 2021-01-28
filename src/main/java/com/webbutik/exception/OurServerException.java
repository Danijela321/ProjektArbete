package com.webbutik.exception;
/**
 * Ta hand om SQL exception pga violation of foreign key
 * @author Danijela
 *
 */

public class OurServerException extends Exception {

	/**
	 * 
	* Konstruktor fran Superklass
	* @param message Skickar meddelande till anvandare
	* @param cause SQL exception (violation of foreign key)
	 */
	public OurServerException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 *
	 * Konstruktor fran Superklass
	 * @param message Skickar meddelande till anvandare
	 */
	public OurServerException(String message) {
		super(message);
	
	}

}
