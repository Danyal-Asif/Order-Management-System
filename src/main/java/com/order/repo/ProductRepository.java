package com.order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.Product;
import com.order.model.ProductCategory;

public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> getProductByCategory(ProductCategory category);
}
