package com.atos.techtest.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * This exception class is used to throw exception when 
 * invalid request is received or the required parameters
 * are missing.  
 * 
 * @author Jateen Udeshi
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid request or required missing parameters")
public class CustomerBadRequestException extends Exception {

	
	private static final long serialVersionUID = -7859357964619576885L;

	public CustomerBadRequestException() {};

}
