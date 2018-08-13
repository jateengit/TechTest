/**
 * 
 */
package com.atos.techtest.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * This exception class is used to throw exception when 
 * a request is received to add customer and the 
 * Customer already exists.  
 * 
 * @author Jateen Udeshi
 *
 */
@ResponseStatus(value=HttpStatus.CONFLICT, reason="This customer already exists in the system")
public class CustomerAlreadyExists extends Exception {

	public CustomerAlreadyExists() {
	}

}
