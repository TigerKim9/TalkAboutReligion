package com.religion.write;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WriteDTO {

	private Long userUid;
	
	private String userName;
	
	//글 내용
	private String contents;
	
	//평점
	private int rank;
}
