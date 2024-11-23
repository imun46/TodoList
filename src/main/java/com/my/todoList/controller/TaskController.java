package com.my.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.todoList.user.UserService;
import com.my.todoList.user.Users;
import com.my.todoList.user.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TaskController {
	
	@Autowired
	private UserService userService;
	
	/*메인페이지*/
	@GetMapping("/task")
	public String main() {
		return "task";
	}

}
