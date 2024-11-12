package com.my.todoList.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityConfig() {
    }
    
    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  
    }
    
    //특정 HTTP 요청에 대한 웹기반 보안 구성
	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	        	//요청에 대한 권한 설정, 인증 인가가필요한 페이지 설정
	            .authorizeHttpRequests(authorize -> authorize
	                .requestMatchers("/signup","/home","/login").permitAll()  // 회원가입 페이지는 인증 안함
	                .requestMatchers("/admin/**").hasRole("ADMIN")  // 관리자 권한 필요
	                .anyRequest().authenticated()) // 나머지 모든 요청은 인증된 사용자만 접근
	            //로그인 설정
	            .formLogin(formLogin -> formLogin
	            		.loginPage("/login")  // 로그인 페이지 경로
	            		.loginProcessingUrl("/login")  // 로그인 처리 URL
	            		.defaultSuccessUrl("/home", true)  // 로그인 후 이동할 페이지
	            		)
		        // 로그아웃 설정
	            .logout(logout -> logout
	                .logoutSuccessUrl("/home")  // 로그아웃 성공 후 리디렉션할 URL
	                .invalidateHttpSession(true)  // 세션 무효화
	            );
	        return http.build();
	    }
	
}
