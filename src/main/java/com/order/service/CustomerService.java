package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.order.dto.CustomerDTO;
import com.order.model.Customer;
import com.order.repo.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
	
	public Customer login(String email,String password) {
		Customer cust=customerRepo.findByEmail(email);
		if(cust !=null) {
			if (passwordEncoder.matches(password, cust.getEncodedPassword())) {
				return cust;
			}
		}
		return null;
	}

	public boolean signup(String name,String email,String password){
		Customer cust=customerRepo.findByEmail(email);
		if(cust != null){
			return false;
		}
		Customer user=new Customer(name,email);
		user.setEncodedPassword(passwordEncoder.encode(password));
		customerRepo.save(user);
		return true;
	}
}
