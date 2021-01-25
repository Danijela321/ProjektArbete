package com.webbutik.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class OurException {
	private final String message;
//	private final Throwable throwable;
	private final HttpStatus httpstatus;
	private final ZonedDateTime timeStamp;



	public OurException(String message, /* Throwable throwable ,*/ HttpStatus httpstatus, ZonedDateTime timeStamp) {
		super();
		this.message = message;
		//this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}
//	public Throwable getThrowable() {
//		return throwable;
//	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}
	public ZonedDateTime getTimestamp() {
		return timeStamp;
	}

}
