package com.religion.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userPid;
	
	@Column(length = 500, nullable = false)
	private String userId;
	
	@Column(length = 500, nullable = false)
	private String userName;
	
	@Column(length = 500, nullable = false)
	private String userAddress;
	
	@Column(length = 500, nullable = false)
	private String userReligion;
	
	@Column(length = 500, nullable = false)
	private String userPhone;
	
	
	
}
