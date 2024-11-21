package com.my.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.todoList.task.TaskService;
import com.my.todoList.task.dto.TaskDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
	/* 할일 등록 */
	@Operation(summary = "할일 등록")
	@PostMapping
	public ResponseEntity<String> createTask(@RequestBody TaskDto taskDto){
		try {
			taskService.createTask(taskDto);
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	
	/* 할일 수정 */
	
	/* 할일 전체 출력(특정 회원) */
	
	/* 할일 출력(detail) */
	
	/* 할일 삭제 */
}
