package com.my.todoList.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.my.todoList.user.UserService;
import com.my.todoList.user.Users;

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
		System.out.println("회원가입폼");
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
		System.out.println("로그인폼");
		return "login";
	}
//	
//	@PostMapping("/login_action")
//	public String loginAction() {
//	    return "redirect:/home";
//	}
	
}
