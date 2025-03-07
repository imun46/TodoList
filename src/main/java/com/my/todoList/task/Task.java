package com.my.todoList.task;

import java.time.LocalDate;
import java.util.Date;

import com.my.todoList.category.Category;
import com.my.todoList.task.dto.TaskDto;
import com.my.todoList.user.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
	private Integer taskNo;
	private String title;
	private String content;
	private LocalDate startDate;
	private LocalDate endDate;
	private String state;
	
	private Category category;
	private Users users;
	
	public static TaskDto toTaskDto(Task task) {
		return TaskDto.builder()
				.taskNo(task.getTaskNo())
				.title(task.getTitle())
				.content(task.getContent())
				.startDate(task.getStartDate())
				.endDate(task.getEndDate())
				.state(task.getState())
				.categoryNo(task.category.getCategoryNo())
				.categoryName(task.getCategory().getName())
				.userNo(task.users.getUserNo())
				.build();
	}
	
	public String toString() {
	    return "Task{" +
	            "taskNo=" + taskNo +
	            ", title='" + title + '\'' +
	            ", content='" + content + '\'' +
	            ", category=" + (category != null ? category : "N/A") +  // user의 ID만 출력
	            ", users=" + (users != null ? users.getUserNo() : "N/A") +  // user의 ID만 출력
	            '}';
	}
	
}
