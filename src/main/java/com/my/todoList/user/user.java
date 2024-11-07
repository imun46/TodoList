package com.my.todoList.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class user {
	private Integer userNo;
	private String id;
	private String password;
	private String email;
}
