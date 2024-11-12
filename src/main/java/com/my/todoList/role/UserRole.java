package com.my.todoList.role;

import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
	private Integer userroleNo;
	private Roles role;
	private Users user;
}
