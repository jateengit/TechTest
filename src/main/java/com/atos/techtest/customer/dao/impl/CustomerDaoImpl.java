package com.atos.techtest.customer.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.atos.techtest.customer.dao.CustomerDao;
import com.atos.techtest.customer.entity.Customer;
import com.atos.techtest.customer.exception.CustomerAlreadyExists;
import com.atos.techtest.customer.exception.CustomerNotFoundException;

/**
 * @inheritDoc
 * This is the implementation of the CustomerDao Interface. 
 * 
 * @author 604536264
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

	private static Map<Integer, Customer> customerMap;

	static {
		customerMap = new HashMap<Integer, Customer>() {
			/**
			 * 
			 */
			

			{
				put(1, new Customer(1, "John", "Wick"));
				put(2, new Customer(2, "Michael", "Jackson"));
				put(3, new Customer(3, "Jackie", "Chan"));
			}
		};
	}

	
	/* (non-Javadoc)
	 * @see com.atos.techtest.customer.dao.CustomerDao#addCustomer(com.atos.techtest.customer.entity.Customer)
	 */
	@Override
	public void addCustomer(Customer customer) throws CustomerAlreadyExists {
		
		if(customerMap.containsKey(customer.getId()))
			throw new CustomerAlreadyExists();
		this.customerMap.put(customer.getId(), customer);
	}

	/* (non-Javadoc)
	 * @see com.atos.techtest.customer.dao.CustomerDao#removeCustomerById(int)
	 */
	@Override
	public void removeCustomerById(int id) throws CustomerNotFoundException {
		if (customerMap.containsKey(id))
			this.customerMap.remove(id);
		else
			throw new CustomerNotFoundException();

	}

	/* (non-Javadoc)
	 * @see com.atos.techtest.customer.dao.CustomerDao#getAllCustomers()
	 */
	@Override
	public Collection<Customer> getAllCustomers() {
		return this.customerMap.values();
	}

}
