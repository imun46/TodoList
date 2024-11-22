package com.my.todoList.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.todoList.task.TaskService;
import com.my.todoList.task.dto.TaskDto;
import com.my.todoList.user.security.CustomUserDetails;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
    
	/* 할일 전체 출력(특정 회원) */
	@Operation(summary = "할일 전체 출력")
	@GetMapping
	public ResponseEntity<List<TaskDto>> findTaskByUserNo(@AuthenticationPrincipal CustomUserDetails userDetails){
		try {
			List<TaskDto> taskList = taskService.findTaskByUserNo(userDetails.getUserNo());
			return ResponseEntity.status(HttpStatus.OK).body(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
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
	@Operation(summary = "할일 수정")
	@PutMapping("/{task_no}")
	public ResponseEntity<String> updateTask(@PathVariable(value="task_no")Integer TaskNo, @RequestBody TaskDto taskDto){
		try {
			taskService.update(taskDto);
			return ResponseEntity.status(HttpStatus.OK).body("수정성공");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	

	/* 할일 출력(detail) */
	@Operation(summary = "할일 1개 출력")
	@GetMapping(value="/{task_no}")
	public ResponseEntity<TaskDto> findTaskByTaskNo(@PathVariable(value="task_no") Integer TaskNo){
		try {
			TaskDto task = taskService.findTaskByTaskNo(TaskNo);
			return ResponseEntity.status(HttpStatus.OK).body(task);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	/* 할일 삭제 */
}
