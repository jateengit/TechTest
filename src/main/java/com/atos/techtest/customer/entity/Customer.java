package com.atos.techtest.customer.entity;

/**
 * This class represents the Customer Bean
 * 
 * @author Jateen Udeshi
 *
 */
public class Customer {

	public Customer() {
	}

	/**
	 * @param id
	 * @param firstName
	 * @param surName
	 */
	public Customer(int id, String firstName, String surName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
	}

	private int id;
	private String firstName;
	private String surName;

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @param surName
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

}
