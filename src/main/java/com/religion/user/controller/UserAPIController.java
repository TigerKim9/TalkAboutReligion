package com.religion.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.religion.user.User;
import com.religion.user.service.UserService;

@Controller
public class UserAPIController {
	
	UserService userService;
	
	@GetMapping("/login")
	public String loginPage(User user) {
		return "home";
	}
	@GetMapping("regist")
	public String sign_up(User user) {
		return "sign_up";
	}

}
