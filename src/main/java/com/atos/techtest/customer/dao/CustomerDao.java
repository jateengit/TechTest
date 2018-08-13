package com.atos.techtest.customer.dao;

import java.util.Collection;

import com.atos.techtest.customer.entity.Customer;
import com.atos.techtest.customer.exception.CustomerAlreadyExists;
import com.atos.techtest.customer.exception.CustomerNotFoundException;

/**
 * The interface defines the methods that can be used to 
 * add customer, remove customer or fetch list of the customers
 * from the repository.
 * 
 * 
 * @author 604536264
 *
 */
public interface CustomerDao {

	/**
	 * Method fetches the list of the customers from 
	 * the repository
	 * 
	 * @return
	 */
	Collection<Customer> getAllCustomers();

	/**
	 * Method for removing the customer from the repository
	 * by providing the Id
	 * 
	 * @param id
	 * @throws CustomerNotFoundException
	 */
	void removeCustomerById(int id) throws CustomerNotFoundException;

	/**
	 * Method for adding the new customer into the repository.
	 * 
	 * 
	 * @param customer
	 * @throws CustomerAlreadyExists
	 */
	void addCustomer(Customer customer) throws CustomerAlreadyExists;

}