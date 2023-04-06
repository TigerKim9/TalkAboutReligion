package com.religion.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.religion.user.User;
import com.religion.user.service.UserService;
import com.religion.write.WriteDTO;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
	
	UserService userService;
	
	@GetMapping("/adminLogin")
	public String adminLoginPage(User user) {
		return "adminLogin";
	}
	
	@GetMapping("/adminUser")
	public String adminUser(User user) {
		return "adminUser";
	}
	
	@GetMapping("/adminWrite")
	public String adminWrite(WriteDTO writeDTO) {
		return "adminWrite";
	}

}


