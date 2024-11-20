package com.my.todoList.user;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.my.todoList.role.UserRoles;
import com.my.todoList.task.Task;
import com.my.todoList.user.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
	private Integer userNo;
	private String id;
	private String password;
	private String email;
	private List<Task> taskList;
	private List<UserRoles> userRoles;
	
   /*
    * @description 패스워드 저장시 자동 암호화
    */
	public Users encodePassword(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(password);
		return this;
	}
	
	public Users toUsers(UserDto userDto) {
		return Users.builder()
				.userNo(userDto.getUserNo())
				.id(userDto.getId())
				.password(userDto.getPassword())
				.email(userDto.getEmail())
				.build();
	}
	
	
	public void addTask(Task task){
		taskList.add(task);
		task.setUsers(this);
	}
	
	public void addUserRole(UserRoles userRole){
		userRoles.add(userRole);
		userRole.setUser(this);
	}
}
