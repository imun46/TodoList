package com.my.todoList.user.dto;

import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private Integer userNo;
	private String id;
	private String password;
	private String email;
	
	
	public static UserDto toUserDto(Users user) {
		return UserDto.builder()
				.userNo(user.getUserNo())
				.id(user.getId())
				.password(user.getPassword())
				.email(user.getEmail())
				.build();
	}
}
