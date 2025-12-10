package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.ProductDTO;
import com.order.model.Product;
import com.order.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product getProduct(Long id) {
		return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public String saveProduct(ProductDTO productDto) {
		Product product=new Product(productDto.getName(),productDto.getPrice(),productDto.isInStock());
		productRepo.save(product);
		return "Product Added Successfully";
	}
}
