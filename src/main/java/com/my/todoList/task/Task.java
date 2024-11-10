package com.my.todoList.task;

import java.util.Date;

import com.my.todoList.category.Category;
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
	private Date endDate;
	private Date startDate;
	private String state;
	private Category category;
	private Users user;
}
