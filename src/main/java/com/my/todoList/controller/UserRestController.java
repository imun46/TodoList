package com.my.todoList.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.todoList.user.UserService;
import com.my.todoList.user.Users;
import com.my.todoList.user.dto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;

    
	/* 회원가입 */
	
//	@PostMapping("/signup")
//	public ResponseEntity<String> signup(@RequestBody Users user){
//			try {
//				Integer signupSuccess= userService.creatUser(user);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return ResponseEntity.status(HttpStatus.CONFLICT).build();
//			}
//			return ResponseEntity.status(HttpStatus.OK).body("가입성공");
//	}
	@Operation(summary = "회원가입")
	@PostMapping("/signup")
	public Map signup(@RequestBody UserDto user){
		
		Map resultMap = new HashMap<>();
		int status = 1;
		String msg = "";
		List data = new ArrayList<>();
		
		try {
			Integer signupSuccess = userService.creatUser(user);
			status = 1;
			msg = "가입 성공";
			data.add(user);
		} catch (Exception e) {
			status = 2;
			msg = "가입 실패";
			e.printStackTrace();
		}
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
	     
		return resultMap;
	}
	
	@Operation(description = "로그인 실패")
	@GetMapping("/login-error")
	public ResponseEntity<Map<String,String>> loginError(HttpServletRequest request) {
	    // 로그인 실패 시 error 파라미터를 모델에 추가
	    String errorMessage = (String) request.getAttribute("error");
	    Map<String, String> response = new HashMap<>();
	    
	    if (errorMessage != null) {
	    	 response.put("error", errorMessage);
	    } else {
	    	 response.put("error", "아이디 또는 비밀번호가 맞지 않습니다.");
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 401 Unauthorized 상태 코드 반환
	}
	
	/* 회원 한명 출력 */
	@Operation(summary = "회원 상세보기")
	@Parameter(name="user_no", description = "유저 번호")
	@GetMapping(value="/{user_no}", produces="application/json;charset=UTF-8")
	public ResponseEntity<UserDto> userDetail(@PathVariable(value="user_no") Integer userNo){
		try {
			Users user = userService.findUserByUserNo(userNo);
			UserDto resultUser = UserDto.toUserDto(user);
			return ResponseEntity.status(HttpStatus.OK).body(resultUser);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	/* 회원 정보 수정 */
	@Operation(summary = "회원 정보 수정")
	@Parameter(name="user_no", description = "유저 번호")
	@PutMapping("/{user_no}")
	public ResponseEntity<UserDto> updateUser(@PathVariable(value="user_no") Integer userNo,UserDto userDto){
		try {
			userService.updateUser(userDto);
			return ResponseEntity.status(HttpStatus.OK).body(userDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	/* 회원 전체 출력 */
	@Operation(summary = "회원 전체리스트", description = "회원 전체리스트")
	@GetMapping("/list")
	public ResponseEntity<List<Users>> userList(){
		try {
			List<Users> userList = userService.findUserAll();
			return ResponseEntity.status(HttpStatus.OK).body(userList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
