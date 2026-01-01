package com.order.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
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

	@GetMapping("/admin")
	public String adminPage() {
		return "admin-utility";
	}
}
