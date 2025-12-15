package com.order.UIcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/CCA/auth")
public class AuthController {

	@Autowired
	private CustomerService	customerService;
	
	// @GetMapping("/login")
	// public String loginPage(@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
	// 	return "login";
	// }
	
	@PostMapping("/signup")
	public String signupPage(@RequestParam String name,@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
		
		boolean success=customerService.signup(name, email, password);
		if (success) {
			model.addAttribute("message","User Signed up successfully.");
			return "signup-success";
		}
		else{
			model.addAttribute("message","Signup Failed!");
			return "signup-failure";
		}
	}
}
