package com.pie_shop.customer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pie_shop.customer.entity.Customer;
import com.pie_shop.customer.repository.CustomerRepository;
import com.pie_shop.exceptions.ConstraintViolationException;
import com.pie_shop.exceptions.ResourceNotFoundException;
import com.pie_shop.orders.entity.Order;

@Service
public class CustomerServiceImp implements CustomerService {
	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override // throws a 400 error if there is an existing record with same id
	public Customer createCustomer(Customer customer) {
		int id = customer.getCustomerId();
		if (customerRepository.existsById(id)) {
			throw new ConstraintViolationException("Review", "Id", id);
		}
		return customerRepository.save(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> getCustomerByName(String lastName) {
		List<Customer> allCustomers = customerRepository.findAll();
		List<Customer> returnlist = new ArrayList<>();
		//@formatter:off
		allCustomers.stream()
		.forEach(c -> 
		{if(c.getLastName().equalsIgnoreCase(lastName))
		returnlist.add(c); }); 
		
     
		return returnlist;
		//@formatter:on

	}

	@Override
	public Customer editCustomer(Customer customer, int id) {
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setPhoneNumber(customer.getPhoneNumber());

		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public void deleteCustomer(Customer customer, int id) {
		  Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer","Id", id));
		customerRepository.deleteById(id);		
	}

}
