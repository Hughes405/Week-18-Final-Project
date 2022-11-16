package com.pie_shop.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.pie_shop.customer.entity.Customer;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column(value = "first_name")
	private String firstName;

	@Column(value = "last_name")
	private String lastName;

	@Column(value = "address")
	private String address;

	@Column(value = "phone_number")
	private String phoneNumber;

}
