package com.atos.techtest.customer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerTestHelper {

	public CustomerTestHelper() {
		// TODO Auto-generated constructor stub
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
