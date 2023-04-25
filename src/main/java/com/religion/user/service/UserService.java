package com.religion.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.religion.user.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	User user;
	UserMapper umapper;
	
	
	//중복아이디 체크
	public int idCheck(String userId) {
		int cnt = umapper.idCheck(userId);
		
		//검색기록
		umapper.searchLog(userId);
		return cnt;
	}
	
	// 회원가입
	// ROLE_MEMBER 권한 부여
	@Transactional
	public int addMember(User user) {
		int cnt = umapper.addUser(user);
		umapper.addAuth(user.getUserPid(), "ROLE_MEMBER");
		return cnt;
	}
	
	// 회원삭제
	@Transactional
	public int deleteMember(User user) {
		umapper.deleteAuths(user.getUserPid());  // 권한(들) 먼저 삭제
		int cnt = umapper.deleteUser(user);
		return cnt;
	}
	
	// 회원정보 조회
	// 특정 id(username) 의 정보 가져오기
	public User findById(String id) {
		//검색기록
		umapper.searchLog(id);
		//TODO 검색기록내용 추가하기 INSERT INTO 누가 무엇을 언제 검색했는가?
		return umapper.findById(id);
	}
	
	// 특정 id 의 권한(들) 정보 가져오기
	public List<String> selectAuthoritiesById(Long userId){
		return umapper.selectAuthoritiesById(userId);
	}
}
