package com.religion.write;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.religion.config.CustomUserDetails;
import com.religion.user.User;

@Service
public class WriteService {

	User user;
	
	WriteMapper writeMapper;
	
	//평가글 작성
	public int write(
			WriteDTO writeDTO
			,@AuthenticationPrincipal CustomUserDetails user) {
		if(user == null) {return 0;}
		writeDTO.setUserName(user.getUsername());
		int result = writeMapper.write(writeDTO);
		
		return result;
	}
	//글 조회
	public List<WriteDTO> viewWrite() {
		
		List<WriteDTO> result = writeMapper.viewWrite();
		
		return result;
	}
	
	//글 삭제
	public int deleteWrite(WriteDTO writeDTO) {
		
		int result = writeMapper.deleteWrite(writeDTO);
		writeMapper.deleteRecord(writeDTO);
		return result;
	}
	
	
	//글 수정
	public int updateWrite(WriteDTO writeDTO) {
		int result = writeMapper.updateWrite(writeDTO);
		writeMapper.updateRecord(writeDTO);
		return result;
	}
}
