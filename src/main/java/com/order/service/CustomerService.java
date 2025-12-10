package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.dto.CustomerDTO;
import com.order.model.Customer;
import com.order.repo.CustomerRepository;

public class CustomerService {
	@Autowired
	CustomerRepository customerRepo;
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer getCustomer(Long id) {
		return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	public String addCustomer(CustomerDTO customerDto) {
		Customer customer=new Customer(customerDto.getName(),customerDto.getEmail());
		customerRepo.save(customer);
		return "New User Added Successfully";
	}

}
