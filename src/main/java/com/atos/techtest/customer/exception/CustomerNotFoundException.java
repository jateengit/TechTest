package com.atos.techtest.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * This exception class is used to throw exception when 
 * a request is received to delete customer and the 
 * Customer is not found in the system.  
 * 
 * @author Jateen Udeshi
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="This customer was not found in the system")
public class CustomerNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	
	
}
