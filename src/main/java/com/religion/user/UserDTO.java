package com.religion.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userPid;
	
	@Column(length = 500, nullable = false)
	private String userId;

	@Column(length = 500, nullable = false)
	private String userPassword;
	
	@Column(length = 500, nullable = false)
	private String userName;
	
	@Column(length = 500, nullable = false)
	private String userAddress;
	
	@Column(length = 500, nullable = false)
	private String userReligion;
	
	@Column(length = 500, nullable = false)
	private String userPhone;

	@Column(length = 500, nullable = false)
	private boolean isActivated;
	
	
	
}
