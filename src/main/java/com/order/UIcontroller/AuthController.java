package com.order.UIcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ui/auth")
public class AuthController {

	@Autowired
	private CustomerService	customerService;
	
	@GetMapping("/login")
	public String loginPage(@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signupPage() {
		return "signup";
	}
}
