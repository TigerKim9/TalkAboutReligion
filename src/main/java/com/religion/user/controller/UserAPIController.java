package com.religion.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.religion.user.User;
import com.religion.user.service.UserService;

@RestController
public class UserAPIController {
	
	UserService userService;
	
	
	@PostMapping("regist")
	public int sign_up(User user) {
		int result = userService.addMember(user);
		return result;
	}

}
