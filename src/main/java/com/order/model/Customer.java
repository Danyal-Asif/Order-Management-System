package com.order.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
private String name;
private String email;
private String password;
 @Transient
private List<Cart> cart;

public Customer() {}

public Customer(String name, String email) {
	this.name = name;
	this.email = email;
	this.cart=null;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getEncodedPassword() {
	return password;
}

public void setEncodedPassword(String encodedPassword) {
    this.password = encodedPassword;
}

public List<Cart> getCart() {
	return cart;
}

public void setCart(List<Cart> cart) {
	this.cart = cart;
}



}
