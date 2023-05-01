package com.religion.user.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.religion.user.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    List<User> findAllByUserPid(Long userPid);
    
}