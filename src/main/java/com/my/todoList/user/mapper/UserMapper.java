package com.my.todoList.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.my.todoList.role.UserRoles;
import com.my.todoList.user.Users;

@Mapper
public interface UserMapper {
	
	public int insert(Users user) throws Exception;
	public int insertUserRole(UserRoles userRole) throws Exception;
	
	public int update(Users user) throws Exception;
	public int delete(Integer UserNo) throws Exception;
	public Users selectUserByNo(Integer userNo) throws Exception;
	public Users selectUserById(String id) throws Exception;
	
}
