package com.my.todoList.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		//DB에서 로그인 정보와 일치하는 사용자 정보를 찾아 DTO에 담아
		UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
		
		// 비밀번호 검증
	    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
	        throw new BadCredentialsException("Invalid username or password");
	    }
	    	
        //일치하는 사용자가 있을 경우 인증 토큰을 발급한다
        return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
    }
	@Override
	public boolean supports(Class<?> authentication) {
		//provider의 동작 여부를 결정한다. false가 리턴되면 authenticate 메서드는 호출되지 않는다
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	
	
}
