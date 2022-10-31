package com.religion.write;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WriteDTO {

	//유저아이디
	private Long userUid;
	
	//작성자
	private String userName;
	
	//교회 
	private String church;
	
	//글 내용
	private String contents;
	
	//평점
	private int rank;
}
