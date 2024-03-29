package com.religion.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.religion.user.User;
import com.religion.user.UserDTO;
import com.religion.user.service.UserService;

public class CustomUserDetails implements UserDetails {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private User user;

	public CustomUserDetails(User user) {
		System.out.println("PrincipalDetails(user) 생성: " + user);
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getAuthorities() 호출");

		Collection<GrantedAuthority> collect = new ArrayList<>();

		List<String> list = userService.selectAuthoritiesById(user.getUserPid());

		for (String auth : list) {
			collect.add(new GrantedAuthority() {

				@Override
				public String getAuthority() {
					return auth;
				}
			});
		}

		return collect;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	// 계정이 만료된건 아닌지?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠긴건 아닌지?
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 계정 credential 이 만료된건 아닌지?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화 되었는지?
	@Override
	public boolean isEnabled() {
		return true;
		// ex)
		// 사이트에서 1년동안 회원이 로그인을 안하면 휴면계정으로 하기로 했다면?
		// 현재시간 - 로그인시간 => 1년을 초과하면 false
	}


}
