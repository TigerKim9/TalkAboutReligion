package com.religion;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.cj.xdevapi.Statement;

@SpringBootTest
class TalkAboutReligionApplicationTests {

	// JDBC 관련 기본 객체 변수들 선언
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;   // executeQuery(), SELECT 결과 
		int cnt = 0;           // executeUpdate(), DML 결과	
		
		// MySQL
		public static final String DRIVER = "com.mysql.cj.jdbc.Driver";  // JDBC 드라이버 클래스
		public static final String URL = "jdbc:mysql://localhost:3306/mydb720";  // DB 서버 정보
		public static final String USERID = "myuser720";   // DB 사용자 계정 정보
		public static final String USERPW = "1234";

		public static final String SQL_WRITE_INSERT = 
				"INSERT INTO test_write" + 
						"(wr_subject, wr_content, wr_name, wr_viewcnt) " +
						"VALUES(?, ?, ?, ?)";	
		
		public static final String [] SUBJECTS = {};
		public static final String [] CONTENTS = {};
		public static final String [] NAMES = {};
		
		@Test
		void test() {
			fail("Not yet implemented");
		}

		
		@Test
		void genData() {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USERID, USERPW);
				
				// 테스트용 dummy 데이터 만들기
				pstmt = conn.prepareStatement(SQL_WRITE_INSERT);
				
				int num = 300; // 다량의 데이터
				Random rand = new Random();
				
				for(int i = 0; i < num; i++) {
					pstmt.setString(1, SUBJECTS[rand.nextInt(SUBJECTS.length)]);
					pstmt.setString(2, CONTENTS[rand.nextInt(CONTENTS.length)]); 
					pstmt.setString(3, NAMES[rand.nextInt(NAMES.length)]);
					pstmt.setInt(4, rand.nextInt(100));
					cnt += pstmt.executeUpdate();
				}
				System.out.println(cnt + "개 의 데이터가 INSERT 되었습니다");
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

}
