package com.my.todoList.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	private PasswordEncoder passwordEncoder;
	
	/*회원가입*/
	public Integer creatUser(Users user) throws Exception {
		Users newUser = Users.builder()
				.id(user.getId())
				.password(passwordEncoder.encode(user.getPassword())) //비밀번호 암호화
				.email(user.getEmail())
				.build();
		
		return userDao.insert(newUser);
	}
	
	/*유저 정보 수정*/
	public Integer updateUser(Users user) throws Exception {
		return userDao.update(user);
	}
	
	/*회원 탈퇴*/
	public Integer deleteUser(Integer userNo) throws Exception {
		return userDao.delete(userNo);
	}
	
	/*특정회원 출력(번호로 찾기)*/
	public Users findUserByUserNo(Integer userNo) throws Exception {
		return userDao.selectUserByNo(userNo);
	}
	
	/*특정회원 출력(아이디로 찾기)*/
	public Users findUserById(String id) throws Exception {
		return userDao.selectUserById(id);
	}
	
	/*로그인 유저 정보*/
	public Users loginUser(String id, String password) throws Exception{
		
		Users loginUser = userDao.selectUserById(id);
		
		if(loginUser == null) {
			return null;
		}
		
		return userDao.selectUserById(id);
	}

	/* 로그인 시큐리티 관련 메소드*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
