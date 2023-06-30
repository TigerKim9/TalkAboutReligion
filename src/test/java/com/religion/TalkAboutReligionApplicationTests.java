package com.religion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.religion.user.User;
import com.religion.user.service.UserService;
import com.religion.write.Status;
import com.religion.write.WriteService;

@SpringBootTest
class TalkAboutReligionApplicationTests {

	UserService userService;
		@Test
		void test() {
			fail("Not yet implemented");
		}

		
		@Test
		void genData() {
			int num1 = 2;
			String operater ="+";
			int num2 = 3;
			
			userService.idCheck(operater);
			
			assertThat(operater);
			
			
		}

}
