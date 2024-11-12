package com.my.todoList.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	
	@Autowired
	private Users user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자가 가진 권한을 반환. 예: "ROLE_USER", "ROLE_ADMIN"
	        ArrayList<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
	        roleList.add(new SimpleGrantedAuthority(user.getAuthorities().getAuthority()));
	        return roleList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
