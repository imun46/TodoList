package com.my.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.todoList.user.UserService;
import com.my.todoList.user.Users;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class IndexController {
	
	/*메인페이지*/
	@GetMapping("/home")
	public String main() {
		return "home";
	}
}
