package com.atos.techtest.customer.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atos.techtest.customer.entity.Customer;
import com.atos.techtest.customer.exception.CustomerAlreadyExists;
import com.atos.techtest.customer.exception.CustomerBadRequestException;
import com.atos.techtest.customer.exception.CustomerNotFoundException;
import com.atos.techtest.customer.service.CustomerService;

/**
 * The Customer Controller program handles incoming HTTP requests and send
 * response back to the caller.
 *
 * @author Jateen Udeshi
 * 
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * This POST method is used to create the customer. 
	 * 
	 * @param customer
	 * @return ResponseEntity<Object>
	 * @throws CustomerAlreadyExists
	 * @throws CustomerBadRequestException
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer)
			throws CustomerAlreadyExists, CustomerBadRequestException {

		customerService.addCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	/**
	 * 
	 * This DELETE method is used to remove the customer 
	 * from the system. 
	 * 
	 * @param id
	 * @throws CustomerNotFoundException
	 */
	@DeleteMapping(value = "/{id}")
	public void removeCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException {
		customerService.removeCustomerById(id);
	}

	/**
	 * 
	 * This GET customer is used to retrieve the list of 
	 * customers in the system.
	 * 
	 * @return Collection<Customer>
	 */
	@GetMapping
	public Collection<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

}
