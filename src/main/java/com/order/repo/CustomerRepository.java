package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
}
