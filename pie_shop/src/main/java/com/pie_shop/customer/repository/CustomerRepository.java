package com.pie_shop.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pie_shop.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
