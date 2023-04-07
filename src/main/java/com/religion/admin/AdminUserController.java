package com.religion.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.religion.user.User;
import com.religion.user.service.UserService;
import com.religion.write.WriteDTO;
import com.religion.write.WriteService;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
	
	UserService userService;
	WriteService writeService;
	
	//관리자 로그인 페이지
	@GetMapping("/adminLogin")
	public String adminLoginPage(User user) {
		return "adminLogin";
	}
	
	//관리자단 모든 유저 조회
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/adminUser")
	public String adminUser(User user) {
		return "adminUser";
	}
	
	//관리자단 모든 글 조회
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/adminWrite")
	public String adminWrite(WriteDTO writeDTO) {
		return "adminWrite";
	}

	
}


