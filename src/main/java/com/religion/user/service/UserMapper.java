package com.religion.user.service;

import org.apache.ibatis.annotations.Mapper;

import com.religion.user.UserDTO;

@Mapper
public interface UserMapper {

	int registUser(UserDTO user);
	
}
