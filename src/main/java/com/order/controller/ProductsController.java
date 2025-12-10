package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.ProductDTO;
import com.order.model.Product;
import com.order.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@PostMapping
	public void addProduct(@RequestBody ProductDTO pd) {
		productService.saveProduct(pd);
		System.out.println("*********** Product added Successfully! *************");
	}
	
}
