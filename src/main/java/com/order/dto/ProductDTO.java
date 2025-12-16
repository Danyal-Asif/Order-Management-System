package com.order.dto;

public class ProductDTO {

	private String name;
	private double price;
	private int inStock;
	private category category;

	public enum category {
		ELECTRONICS,
		BOOKS,
		CLOTHING,
		FOOD,
		OTHERS
	}


	public ProductDTO(String name, double price, int inStock,category category) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.category=category;
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
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}
}
