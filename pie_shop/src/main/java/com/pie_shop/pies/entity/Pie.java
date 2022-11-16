package com.pie_shop.pies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.pie_shop.pies.entity.Pie;

import lombok.Data;

@Data
@Entity
@Table (name = "pies")
public class Pie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int pieId;

	@Column(value = "name")
	public String name;

	@Column(value = "description")
	public String description;

	@Column(value = "gluten_free")
	public boolean glutenFree;

	@Column(value = "price")
	public double price;

}
