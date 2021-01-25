package com.webbutik.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandare {
	//vi handlar custom exception
	//argument exception som är skapad
	
	@ExceptionHandler( value= {OurCustomExceptions.class})
	public ResponseEntity<Object> handleException(OurCustomExceptions e){
		//1. skapar vi payload med ndantagsdetaljer
		//message, throwable, httpstatus, timestamp)
		HttpStatus badRequest = HttpStatus.BAD_REQUEST; //bad_request=400
		OurException ourException=new OurException(e.getMessage(),
				//e,  e=Throwable
				badRequest,
				ZonedDateTime.now(ZoneId.of("Europe/Stockholm"))); // här kan vi andra timestamp
		
		//2. return  respons entity
		return new ResponseEntity<>(ourException,badRequest);		
	
	}	


	
	/*
	 * 
	 *    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, 
                HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
	 */
	
	
}
