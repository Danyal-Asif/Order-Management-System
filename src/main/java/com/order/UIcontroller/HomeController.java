package com.order.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class HomeController {
 @GetMapping("/")
 public String index() {
	 return "index";
 }
 @GetMapping("/signup")
	public String signupPage() {
		return "signup";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
