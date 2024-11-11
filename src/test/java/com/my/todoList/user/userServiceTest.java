package com.my.todoList.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class userServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	void testCreatUser() throws Exception {
		Users user = Users.builder()
				.id("a3")
				.password("aaa")
				.email("emfif@naver.com")
				.build();
		System.out.println(userService.creatUser(user));
	}

	@Test
	void testUpdateUser() throws Exception {
		Users user = Users.builder()
				.id("a3")
				.password("aaa")
				.email("emfif@naver.com")
				.build();
		System.out.println(userService.updateUser(user));
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	void testFindUserByUserNo() {
		fail("Not yet implemented");
	}

	@Test
	void testLoginUser() {
		fail("Not yet implemented");
	}

}
