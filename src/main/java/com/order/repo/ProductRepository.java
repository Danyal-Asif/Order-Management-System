package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
