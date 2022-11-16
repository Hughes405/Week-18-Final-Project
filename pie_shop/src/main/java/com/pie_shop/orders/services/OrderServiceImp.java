package com.pie_shop.orders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pie_shop.exceptions.ConstraintViolationException;
import com.pie_shop.exceptions.ResourceNotFoundException;
import com.pie_shop.orders.entity.Order;
import com.pie_shop.orders.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {
	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImp(OrderRepository orderRepository) {
		this.orderRepository= orderRepository;
	}

	@Override // throws a 400 error if there is an existing record with same id
	public Order createOrder(Order order) {
		int id = order.getOrderId();
		if (orderRepository.existsById(id)) {
			throw new ConstraintViolationException("Current Order exists", "Id", id);

		}
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(int id) {
		return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

	}

	@Override
	public Order editOrder(Order order, int id) {
		Order existingOrder = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

		existingOrder.setCustomerId(order.getCustomerId());
		existingOrder.setOrderDate(order.getOrderDate());
		existingOrder.setGiftNote(order.isGiftNote());

		orderRepository.save(existingOrder);
		return existingOrder;
	}

	@Override
	public void deleteOrder(Order order, int id) {
		Order existingOrder = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
		orderRepository.deleteById(id);
	}

}
