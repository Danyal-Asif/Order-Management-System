package com.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	public int instock;
	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private category category;

	public enum category {
		ELECTRONICS,
		BOOKS,
		CLOTHING,
		FOOD,
		OTHERS
	}


	public Product() {
	}

	public Product(String name, double price, int instock,category category) {
		this.name = name;
		this.price = price;
		this.instock = instock;
		this.category=category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInStock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}

}
