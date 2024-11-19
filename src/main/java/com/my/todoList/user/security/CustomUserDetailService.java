package com.my.todoList.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my.todoList.user.UserDao;
import com.my.todoList.user.Users;
import com.my.todoList.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
/* 사용자 정보를 가져올때 이용하는 서비스*/
public class CustomUserDetailService implements UserDetailsService{
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("CustomUserDetailService 확인 userId" + userId);
		try {
			Users user = userDao.selectUserById(userId);
			System.out.println("CustomUserDetailService 확인!!" + user);
			return new CustomUserDetails(user);
		} catch (Exception e) {
			System.out.println("실패 ㅜㅜㅜ");
			throw new UsernameNotFoundException("userID" + userId + " not found");
		}
	}
	
	
}

