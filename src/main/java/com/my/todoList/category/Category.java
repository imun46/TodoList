package com.my.todoList.category;

import java.util.List;

import com.my.todoList.task.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
	private Integer categoryNo;
	private String name;
	private List<Task> taskList;
}
