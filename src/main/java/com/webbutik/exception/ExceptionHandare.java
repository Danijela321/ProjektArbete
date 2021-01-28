package com.webbutik.exception;

/**
 * Handlar exceptions
 * @author Danijela
 */
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandare {
	//vi handlar custom exception
	//argument exception som är skapad
	/**
	 * HttpStatus.BAD_REQUEST
	 * @param e RuntimeException
	 * @return en ny ResponseEntity
	 * @author Danijela
	 */
	@ExceptionHandler( value= {OurCustomExceptions.class})
	public ResponseEntity<Object> handleException(OurCustomExceptions e){
		//1. skapar vi payload med undertagendetaljer
		//message, throwable, httpstatus, timestamp)
		HttpStatus badRequest = HttpStatus.BAD_REQUEST; //bad_request=400
		OurException ourException=new OurException(e.getMessage(),
				//e,  e=Throwable
				badRequest,
				ZonedDateTime.now(ZoneId.of("Europe/Stockholm"))); // här kan vi andra timestamp
		
		//2. return  respons entity
		return new ResponseEntity<>(ourException,badRequest);		
	
	}	
	
	/**
	 * HttpStatus.INTERNAL_SERVER_ERROR
	 * @param ex Exception
	 * @return en ny ResponseEntity
	 * @author Danijela
	 */
	 @ExceptionHandler(value= {OurServerException.class})
	    public final ResponseEntity<Object> handleUnexpectedExceptions(Exception ex) {
		 HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR; //internal server error 500
			OurException ourException=new OurException(ex.getMessage(),
					//e,  e=Throwable
					serverError,
					ZonedDateTime.now(ZoneId.of("Europe/Stockholm"))); // här kan vi andra timestamp
			
			//2. return  respons entity
			return new ResponseEntity<>(ourException,serverError);
	    }

	 /**
	  * HttpStatus.UNAUTHORIZED
	  * @param ex RuntimeException
	  * @return en ny ResponseEntity
	  * @author Danijela
	  */
	 @ExceptionHandler(value= {NotAuthorized.class})
	    public final ResponseEntity<Object> handleUnexpectedExceptions3(Exception ex) {
		 HttpStatus notAuth = HttpStatus.UNAUTHORIZED; // error 403
			OurException ourException=new OurException(ex.getMessage(),
					//e,  e=Throwable
					notAuth,
					ZonedDateTime.now(ZoneId.of("Europe/Stockholm"))); // här kan vi andra timestamp
			
			//2. return  respons entity
			return new ResponseEntity<>(ourException,notAuth);
	    }
	
}
