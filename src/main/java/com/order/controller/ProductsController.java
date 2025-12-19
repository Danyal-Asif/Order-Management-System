package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.order.dto.ProductDTO;
import com.order.mapper.ProductMapper;
import com.order.model.Customer;
import com.order.model.Product;
import com.order.model.ProductCategory;
import com.order.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductMapper productMapper;

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

	@GetMapping("/catPd")
	public String products(@RequestParam(required = false) String pCategory,HttpSession session, Model model) {
		Customer user=(Customer) session.getAttribute("LOGGED_IN_USER");
		if(user==null){
			return "redirect:/login";
		}
		model.addAttribute("name","Welcome, "+user.getName()+" 😎");
		List<Product> products;
		if(pCategory==null||pCategory.isBlank()){
			products=productService.getAllProducts();
		}
		else{
			products=productService.getProductByCategory(ProductCategory.valueOf(pCategory));
		}
		List<ProductDTO> productDTOs=products.stream().map(productMapper::toDto).toList();
		model.addAttribute("products",productDTOs);
		model.addAttribute("categories", ProductCategory.values());

		return "product-page";
	}
	
}
