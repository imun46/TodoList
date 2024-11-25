package com.my.todoList.task.dto;

import java.util.Date;

import org.springframework.security.core.userdetails.User;

import com.my.todoList.category.Category;
import com.my.todoList.task.Task;
import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDto {
	private Integer taskNo;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	private String state;
	private Integer categoryNo;
	private String categoryName;
	private Integer userNo;
	
	public static Task toTask(TaskDto taskDto) {
		return Task.builder()
				.taskNo(taskDto.getTaskNo())
				.title(taskDto.getTitle())
				.content(taskDto.getContent())
				.startDate(taskDto.getStartDate())
				.endDate(taskDto.getEndDate())
				.state(taskDto.getState())
				.category(Category.builder()
						.categoryNo(taskDto.getCategoryNo())
						.name(taskDto.getCategoryName())
						.build())
				.users(Users.builder().userNo(taskDto.userNo).build())
				.build();
	}
}
