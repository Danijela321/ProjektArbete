package com.webbutik.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

/**
 * Egenskap av exceptions meddelande
 * @author Danijela
 *
 */
public class OurException {
	private final String message;
//	private final Throwable throwable;
	private final HttpStatus httpstatus;
	private final ZonedDateTime timeStamp;


/**
 * Element av meddelande som anvandare vill fa
 * @param message Meddelande som anvandare vill fa
 * @param httpstatus Vilken fel hander
 * @param timeStamp  Tid när fel hander
 * @author Danijela
 */
	public OurException(String message, /* Throwable throwable ,*/ HttpStatus httpstatus, ZonedDateTime timeStamp) {
		super();
		this.message = message;
		//this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.timeStamp = timeStamp;
	}
	
	/**
	 * Get meddelande
	 * @return meddelande
	 */
	public String getMessage() {
		return message;
	}
//	public Throwable getThrowable() {
//		return throwable;
//	}
	/**
	 * Get Httpstatus
	 * @return Httpstatus t.ex BAD_REQUEST, INTERNAL_SERVER_ERROR
	 */
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	/**
	 * Get Tid av Europe/Stockholm zone
	 * @return Tid av Europe/Stockholm zone
	 */
	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}
	
	/**
	 * Get Tid av Europe/Stockholm zone
	 * @return Tid av Europe/Stockholm zone
	 */
	public ZonedDateTime getTimestamp() {
		return timeStamp;
	}

}
