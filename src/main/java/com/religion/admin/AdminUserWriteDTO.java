package com.religion.admin;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminUserWriteDTO {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userPid;
	
	@Column(length = 500, nullable = false)
	private String userId;

	@Column(length = 500, nullable = false)
	private String userName;
	
	@Column(length = 500, nullable = false)
	private String userReligion;
	
	@Column(length = 500, nullable = false)
	private String userPhone;

	@Column(length = 500, nullable = false)
	private boolean isActivated;
}


