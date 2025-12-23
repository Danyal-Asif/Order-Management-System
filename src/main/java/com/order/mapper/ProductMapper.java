package com.order.mapper;

import org.springframework.stereotype.Component;

import com.order.dto.ProductDTO;
import com.order.model.Product;

@Component
public class ProductMapper {
    public ProductDTO toDto(Product p){
        return new ProductDTO(p.getId(),p.getName(), p.getPrice(), p.getInStock(), p.getCategory());
    }
}
