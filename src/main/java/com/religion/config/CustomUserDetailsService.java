package com.religion.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.religion.user.User;
import com.religion.user.service.UserService;

//UserDetailsService
//컨테이너에 등록한다.
//시큐리티 설정에서 loginProcessingUrl(url) 로 걸어 놓았기 때문에
//위 url 로 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는
//loadUserByUsername() 가 실행된다.
@Service
public class CustomUserDetailsService implements UserDetailsService{

	Logger loggger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Autowired
	private UserService userService;
	
	// UserDetails 를 리턴한다 --> 누구한테 리턴하나?
	// 시큐리티 sesssion (<= Authentication(<= 리턴된 UserDetails))
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("loadUserByUsername(" + username + ")");
		loggger.info("loadUserByUsername({})", username);
		
		User user = userService.findById(username);
		
		// 해당 id 의 user 가 있다면
		if(user != null) {
			CustomUserDetails userDetails = new CustomUserDetails(user);
			userDetails.setUserService(userService);
			return userDetails;
		}
		
		// 찾지 못했으면!
		return null;
	}

}











