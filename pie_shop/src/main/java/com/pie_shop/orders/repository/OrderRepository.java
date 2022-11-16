package com.pie_shop.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pie_shop.orders.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
