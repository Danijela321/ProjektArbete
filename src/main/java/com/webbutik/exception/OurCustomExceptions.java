package com.webbutik.exception;

/**
 * Ta hand om exception om man vill ta bort car som finns inte i tabell Car,
 * om man vill get car som finns inte i tabell eller skapa en ny bil med samma namn
 * @author Danijela
 *
 */
public class OurCustomExceptions extends RuntimeException{

	/**
	 * Konstruktor fran Superklass
	 * @param message Skickar meddelande till anvandare
	 * 
	 */
	public OurCustomExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}
	/**
	 * Konstruktor fran Superklass
	 * @param message Skickar meddelande till anvandare
	 * 
	 */
	public OurCustomExceptions(String message) {
		super(message);
	
	}

}
