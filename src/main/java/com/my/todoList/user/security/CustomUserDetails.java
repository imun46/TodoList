package com.my.todoList.user.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.my.todoList.role.UserRoles;
import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails{
	
	@Autowired
	private Users user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자가 가진 권한을 반환. 예: "ROLE_USER", "ROLE_ADMIN"
	        ArrayList<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
	        roleList.add(new SimpleGrantedAuthority(user.getUserRoles().toString()));
	        return roleList;
	}
	
	//패스워드 비교를 위한 패스워드 리턴
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	//아이디 비교를 위해 아이디 리턴
	@Override
	public String getUsername() {
		return user.getId();
	}
	
}
