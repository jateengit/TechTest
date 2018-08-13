package com.atos.techtest.customer.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atos.techtest.customer.dao.CustomerDao;
import com.atos.techtest.customer.entity.Customer;
import com.atos.techtest.customer.exception.CustomerAlreadyExists;
import com.atos.techtest.customer.exception.CustomerBadRequestException;
import com.atos.techtest.customer.exception.CustomerNotFoundException;

/**
 * 
 * The Customer Service program handles the business logic 
 * incoming HTTP requests and required orchestration.
 * 
 * @author Jateen Udeshi
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDaoImpl;
	
	/**
	 * This method implements the business logic required 
	 * to fetch the list of the customers available in the 
	 * system. 
	 * 
	 * @return Collection<Customer>
	 */
	public Collection<Customer> getAllCustomers() {
		return customerDaoImpl.getAllCustomers();
	}

	/**
	 * 
	 * This method implements the business logic required 
	 * to add the Customer in the system.
	 * 
	 * @param customer
	 * @throws CustomerAlreadyExists
	 * @throws CustomerBadRequestException
	 */
	public void addCustomer(Customer customer) throws CustomerAlreadyExists, CustomerBadRequestException {
		if (customer == null || customer.getId() < 1) {
			throw new CustomerBadRequestException();
		}
		this.customerDaoImpl.addCustomer(customer);
	}

	/**
	 * This method implements the business logic required 
	 * to remove the Customer from the system.
	 * 
	 * @param id
	 * @throws CustomerNotFoundException
	 */
	public void removeCustomerById(int id) throws CustomerNotFoundException {
		this.customerDaoImpl.removeCustomerById(id);
	}

}
