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
	public String createTask(@AuthenticationPrincipal CustomUserDetails userDetails,Model model){
		model.addAttribute("userNo",userDetails.getUserNo());
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
	@PostMapping("/task_modify_form")
	public String updateTask(@RequestParam(name="taskNo") Integer taskNo, Model model){
		try {
			TaskDto task = taskService.findTaskByTaskNo(taskNo);
			model.addAttribute("task", task);
			return "task_modify_form";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}
	
	@PostMapping("/task_modify_action")
	public String updateTaskAction(@ModelAttribute TaskDto taskDto){
		try {
			System.out.println("controller---->" + taskDto);
			taskService.update(taskDto);
			return "redirect:/task";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}
	
	/*할일 삭제*/
	@PostMapping("/task_delete")
	public String deleteTask(@RequestParam(name="taskNo") Integer taskNo) {
		try {
			taskService.deleteTask(taskNo);
			return "redirect:/task";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
	}

}
