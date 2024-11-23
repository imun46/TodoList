package com.my.todoList.user.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails{
	
	@Autowired
	private Users user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자가 가진 권한을 반환. 예: "ROLE_USER", "ROLE_ADMIN"
	        ArrayList<GrantedAuthority> authoriteis = new ArrayList<>();
	        authoriteis.add(new SimpleGrantedAuthority("ROLE_USER"));
	        return authoriteis;
	}
	
	//패스워드 비교를 위한 패스워드 리턴
	@Override
	public String getPassword() {
		System.out.println("usersyuser" + user.getPassword());
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

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return user.getId();
    }
    
    public Integer getUserNo() {
    	return user.getUserNo();
    }
	
}
