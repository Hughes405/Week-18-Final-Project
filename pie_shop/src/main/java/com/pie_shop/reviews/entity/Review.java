package com.pie_shop.reviews.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.pie_shop.reviews.entity.Review;

import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int reviewId;

	@Column(value = "customer_id")
	public int customerId;

	@Column(value = "text_body")
	public String textBody;

}
