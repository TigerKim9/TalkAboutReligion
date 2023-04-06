package com.religion.write;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.religion.user.User;

@Mapper
public interface WriteMapper {

	//전체 글 조회
	List<WriteDTO> viewWrite();

	//내가 쓴 글 조회
	List<WriteDTO> viewMyWrite(User user);
	
	
	//글 작성
	int write(WriteDTO writeDTO);
	
	//글 삭제
	int deleteWrite(WriteDTO writeDTO);
	
	//글 삭제 기록
	int deleteRecord(WriteDTO writeDTO);
	
	//글 수정
	int updateWrite(WriteDTO writeDTO);
	
	//글 수정 기록
	int updateRecord(WriteDTO writeDTO);
	
	
}
