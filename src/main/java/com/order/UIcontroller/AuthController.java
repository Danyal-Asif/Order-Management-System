package com.order.UIcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.dto.ProductDTO;
import com.order.model.Customer;
import com.order.model.Product;
import com.order.model.ProductCategory;
import com.order.service.CustomerService;
import com.order.service.ProductService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/CCA/auth")
public class AuthController {

	@Autowired
	private CustomerService	customerService;
	
	@PostMapping("/login")
	public String loginPage(@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
		Customer cust=customerService.login(email, password);
		if(cust==null){
			model.addAttribute("message","Login Failed!");
			return "login-failure";
		}
		else{
			session.setAttribute("LOGGED_IN_USER", cust);
			return "redirect:/products/catPd";
		}
	}
	
	@PostMapping("/signup")
	public String signupPage(@RequestParam String name,@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
		
		boolean success=customerService.signup(name, email, password);
		if (success) {
			model.addAttribute("message","SignUp Successfull.");
			return "signup-success";
		}
		else{
			model.addAttribute("message","SignUp Failed!");
			return "signup-failure";
		}
	}

}
