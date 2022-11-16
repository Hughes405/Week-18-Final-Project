package com.pie_shop.orders.services;

import java.util.List;

import com.pie_shop.orders.entity.Order;

public interface OrderService {
	// Create and save a order
	public Order createOrder(Order order);

	// View all orders
	public List<Order> getAllOrders();

	// Find and view order by id
	public Order getOrderById(int id);

	// Edit order
	public Order editOrder(Order order, int id);

	// Delete order
	public void deleteOrder(Order order, int id);

}
