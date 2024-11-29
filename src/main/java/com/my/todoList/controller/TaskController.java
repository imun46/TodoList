package com.my.todoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.todoList.task.TaskService;
import com.my.todoList.task.dto.TaskDto;
import com.my.todoList.user.security.CustomUserDetails;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	/*할일 리스트 페이지*/
	@GetMapping("/task")
	public String main(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
		try {
			List<TaskDto> taskList = taskService.findTaskByUserNo(userDetails.getUserNo());
			model.addAttribute("taskList",taskList);
			return "task"; 
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}
	
	/* 할일 등록 */
	@GetMapping("/task_form")
	public String createTask(){
		return "task_form";
	}
	
	/* 할일 등록 */
	@PostMapping("/task_action")
	public String createTaskAction(@ModelAttribute TaskDto taskDto){
		try {
			taskService.createTask(taskDto);
			return "redirect:/task";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}
	
	/* 할일 수정 */
	@GetMapping("/task_modify_form")
	public String updateTask(@ModelAttribute TaskDto taskDto){
		return "task_modify_form";
	}
	@PostMapping("/task_modify_action")
	public String updateTaskAction(@ModelAttribute TaskDto taskDto){
		try {
			taskService.update(taskDto);
			return "1개 출력";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}
	

	/* 할일 출력(detail) */
	@GetMapping(value="/task_view", params = "task_no")
	public String findTaskByTaskNo(@RequestParam(name="task_no") Integer taskNo, Model model){
		try {
			TaskDto task = taskService.findTaskByTaskNo(taskNo);
			model.addAttribute("task", task);
			return "task_view";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}

}
