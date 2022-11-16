package com.pie_shop.customer.services;

import java.util.List;

import com.pie_shop.customer.entity.Customer;
import com.pie_shop.orders.entity.Order;

public interface CustomerService {
	// Create and save a customer
	public Customer createCustomer(Customer customer);

	// View all customers
	public List<Customer> getAllCustomers();

	// View customer by name
	public List<Customer> getCustomerByName(String lastName);

	// Edit customer
	public Customer editCustomer(Customer customer, int id);
	//Delete customer
	public void deleteCustomer(Customer customer, int id);


}
