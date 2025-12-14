package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Customer;
import com.order.repo.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		Customer customer= customerRepo.findById(id).orElse(null);
		return customer;
	}
	
	@PostMapping
	public String addCustomer(@RequestBody Customer cust) {
		customerRepo.save(cust);
		return "Customer added Successfully!";
	}
}
