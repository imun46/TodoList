package com.my.todoList.user.mapper;

import com.my.todoList.user.Users;

public interface UserMapper {
	
	public int insert(Users user) throws Exception;
	public int update(Users user) throws Exception;
	public Users selectUserByNo(Integer userNo) throws Exception;
	public int delete(Integer UserNo) throws Exception;
	
}
