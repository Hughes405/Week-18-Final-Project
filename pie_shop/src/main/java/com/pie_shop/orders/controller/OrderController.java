package com.pie_shop.orders.controller;

import java.util.List;

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

import com.pie_shop.orders.entity.Order;
import com.pie_shop.orders.services.OrderService;

@RestController
@RequestMapping("/pie_shop/orders")
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("{order_id}")
	public ResponseEntity<Order> getOrdersById(@PathVariable("order_id") int id) {
		return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
	}

	@PutMapping("{order_id}")
	public ResponseEntity<Order> editOrder(@PathVariable("order_id") int id, @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.editOrder(order, id), HttpStatus.OK);
	}

	@DeleteMapping("{order_id}")
	public ResponseEntity<String> deleteOrders(@PathVariable("order_id") int id, @RequestBody Order order) {
		orderService.deleteOrder(order, id);
		return new ResponseEntity<String>("That order: " + id + " was deleted", HttpStatus.OK);
	}

}
