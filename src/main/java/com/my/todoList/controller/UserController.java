package com.my.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.todoList.user.UserService;
import com.my.todoList.user.Users;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*메인페이지*/
	@GetMapping("/home")
	public String main() {
		return "home";
	}
	
	/*회원가입*/
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup_action")
	public String signupAction(@ModelAttribute Users user){
	    try {
			userService.creatUser(user);
			return "redirect:/login";    
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home";    
		}  
	}
	
	/*로그인*/
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login-error")
	public String loginError(Model model, HttpServletRequest request) {
	    // 로그인 실패 시 error 파라미터를 모델에 추가
	    String errorMessage = (String) request.getAttribute("error");
	    if (errorMessage != null) {
	        model.addAttribute("error", errorMessage);
	    } else {
	        model.addAttribute("error", "아이디 또는 비밀번호가 맞지 않습니다.");
	    }
	    return "login-error"; // 로그인 오류 페이지로 이동
	}
}
