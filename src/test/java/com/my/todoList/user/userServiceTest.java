package com.my.todoList.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.todoList.user.dto.userSignupDto;

@SpringBootTest
class userServiceTest {
	
	@Autowired
	private UserService userService;
	
//	@Test
	void testCreatUser() throws Exception {
		userSignupDto user = userSignupDto.builder()
				.id("hhh")
				.password("aaa")
				.email("emfif@naver.com")
				.build();
		System.out.println(userService.creatUser(user));
	}

//	@Test
	void testUpdateUser() throws Exception {
		Users user = Users.builder()
				.userNo(2)
				.id("changeId")
				.password("aaa")
				.email("emfif@naver.com")
				.build();
		System.out.println(userService.updateUser(user));
	}

//	@Test
	void testDeleteUser() throws Exception {
		System.out.println(userService.deleteUser(3));
	}

	
//	@Test
	void testFindUserByUserNo() throws Exception {
		System.out.println(userService.findUserByUserNo(2));
	}

//	@Test
//	void testLoginUser() {
//		fail("Not yet implemented");
//	}
	@Test
	void testUserAll() throws Exception {
		System.out.println(userService.findUserAll());
	}
}
