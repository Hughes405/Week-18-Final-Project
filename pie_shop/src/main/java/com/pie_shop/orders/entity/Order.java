package com.pie_shop.orders.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.pie_shop.orders.entity.Order;

import lombok.Data;


@Data
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// ??
	private int orderId;

	@Column(value = "customer_id")
	private int customerId;
	
			
	@Column(value = "order_date")
	private Date orderDate;

	@Column(value = "gift_note")
	private boolean giftNote;

}
