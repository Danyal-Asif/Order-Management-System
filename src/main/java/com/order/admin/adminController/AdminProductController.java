package com.order.admin.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.dto.ProductDTO;
import com.order.mapper.ProductMapper;
import com.order.model.Product;
import com.order.model.ProductCategory;
import com.order.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminUI")
public class AdminProductController {

    @Autowired
	ProductService productService; 

	@Autowired
	ProductMapper productMapper;

    @GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

    @GetMapping("/initEdit")
	public String initiateEditProduct( Model model){
		List<Product> products=getAllProducts();
		model.addAttribute("categories", ProductCategory.values());
        model.addAttribute("products", products);
        return "edit-product-List";
	}

    @GetMapping("/products/category")
	public String adminViewByCategory(@RequestParam(required = false) String pCategory, HttpSession session, Model model) {
		List<Product> products;
		if (pCategory == null || pCategory.isBlank()) {
			products = productService.getAllProducts();
		} else {
			products = productService.getProductByCategory(ProductCategory.valueOf(pCategory));
		}
		List<ProductDTO> productDTOs = products.stream().map(productMapper::toDto).toList();
		model.addAttribute("products", productDTOs);
		model.addAttribute("categories", ProductCategory.values());

		return "edit-product-List";
	}
    @PostMapping("/edit")
	public String editProduct(@ModelAttribute ProductDTO pd) {
		System.out.println("/products/edit");
		productService.editProduct(pd);
		System.out.println("*********** Product updated Successfully! *************");
		return "redirect:/admin";
	}
}
