package com.my.todoList.task;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class task {
	private Integer taskNo;
	private String title;
	private String content;
	private Date endDate;
	private String category;
	private String state;
	
}
