package com.my.todoList.role;

import javax.management.relation.Role;

import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRoles {
	private Integer userRoleNo;
	private Users user;
	private Roles role;
	
}
