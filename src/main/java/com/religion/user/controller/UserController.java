package com.religion.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.religion.user.User;
import com.religion.user.service.UserService;

@Controller
public class UserController {
	
	UserService userService;
	
	@GetMapping("/login")
	public String loginPage(User user) {
		return "home";
	}
	
	@GetMapping("/regist")
	public String sign_up(User user) {
		return "regist";
	}
	
	@GetMapping("/about")
	public String about(User user) {
		return "About";
	}
	
	@GetMapping("/contact")
	public String contact(User user) {
		return "Contact";
	}

	@GetMapping("/Home")
	public String home(User user, Model model) {
		
		model.addAttribute("Title","yes");
		return "Home";
	}
	
	@GetMapping("/index")
	public String indext(User user) {
		return "index";
	}

}


