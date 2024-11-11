package com.my.todoList.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
	@Autowired
	private UserDao userDao;
	
	
	/*회원가입*/
	public Integer creatUser(Users user) throws Exception {
		return userDao.insert(user);
	}
	
	/*유저 정보 수정*/
	public Integer updateUser(Users user) throws Exception {
		return userDao.update(user);
	}
	
	/*회원 탈퇴*/
	public Integer deleteUser(Integer userNo) throws Exception {
		return userDao.delete(userNo);
	}
	
	/*특정회원 출력*/
	public Users findUserByUserNo(Integer userNo) throws Exception {
		return userDao.select(userNo);
	}
	
}
