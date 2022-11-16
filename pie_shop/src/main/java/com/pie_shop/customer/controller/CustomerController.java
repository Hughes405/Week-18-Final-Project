package com.pie_shop.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pie_shop.customer.entity.Customer;
import com.pie_shop.customer.services.CustomerService;
import com.pie_shop.orders.entity.Order;

@RestController
@RequestMapping("/pie_shop/customer")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();

	}

	@GetMapping("{last_name}") // this method throws an error
	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable("last_name") String lastName) {
		return new ResponseEntity<List<Customer>>(customerService.getCustomerByName(lastName), HttpStatus.OK);

	}

	@PutMapping("{customer_id}")
	public ResponseEntity<Customer> editCustomer(@PathVariable("customer_id") int id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.editCustomer(customer, id), HttpStatus.OK);
	}
	@DeleteMapping("{customer_id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customer_id") int id, @RequestBody Customer customer) {
		customerService.deleteCustomer(customer, id);
		return new ResponseEntity<String>("That customer: " + id + " was deleted", HttpStatus.OK);
	}
}
