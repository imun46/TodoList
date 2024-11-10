package com.my.todoList.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.todoList.user.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserMapper userMapper;
	
	public UserDaoImpl() {

	}

	@Override
	public int insert(Users user) throws Exception {
		return userMapper.insert(user);
	}

	@Override
	public int update(Users user) throws Exception {
		return userMapper.update(user);
	}

	@Override
	public Users select(Integer userNo) throws Exception {
		return userMapper.select(userNo);
	}

	@Override
	public int delete(Integer UserNo) throws Exception {
		return userMapper.delete(UserNo);
	}

}