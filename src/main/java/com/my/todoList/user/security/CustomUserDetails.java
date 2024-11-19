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
public class CustomUserDetails implements UserDetails{
	
	private final Users user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자가 가진 권한을 반환. 예: "ROLE_USER", "ROLE_ADMIN"
	        ArrayList<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
	        for (UserRoles role : user.getUserRoles()) {
	            roleList.add(new SimpleGrantedAuthority(role.getRole().getName()));
	        }
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

	@Override
	public boolean isAccountNonExpired() {
	    return true;  // 계정 만료 여부 (실제 로직에 따라 처리)
	}

	@Override
	public boolean isAccountNonLocked() {
	    return true;  // 계정 잠금 여부 (실제 로직에 따라 처리)
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true;  // 자격 증명 만료 여부 (실제 로직에 따라 처리)
	}

	
}
