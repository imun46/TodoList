package com.my.todoList.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.todoList.category.CategoryDao;
import com.my.todoList.category.CategoryService;
import com.my.todoList.task.dto.TaskDto;

@Service
public class TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private CategoryService categoryService;
	
	/*할일 저장*/
	public Integer createTask(TaskDto taskDto) throws Exception {
		String categoryName = categoryService.selectCategoryName(taskDto.getCategoryNo());
		taskDto.setCategoryName(categoryName);
		Task task = TaskDto.toTask(taskDto);
		return taskDao.insert(task);
	}
	/*할일 삭제*/
	public Integer deleteTask(Integer taskNo) throws Exception{
		return taskDao.delete(taskNo);
	}
	/*할일 수정*/
	public Integer update(TaskDto taskDto) throws Exception{
		Task task = TaskDto.toTask(taskDto);
		System.out.println("taskService-->" + task);
		return taskDao.update(task);
	}
	/*할일 출력 특정 pk 한개*/
	public TaskDto findTaskByTaskNo(Integer TaskNo) throws Exception{
		Task task = taskDao.selectByTaskNo(TaskNo);
		return Task.toTaskDto(task); 
	}
	
	/*할일 전체 출력 (특정 유저)*/
	public List<TaskDto> findTaskByUserNo(Integer UserNo) throws Exception{
		List<Task> taskList = taskDao.selectByUserNo(UserNo);
		List<TaskDto> taskDtoList = new ArrayList<>();
		for (Task task : taskList) {
			taskDtoList.add(Task.toTaskDto(task));
		}
		return taskDtoList;
				
	}
}
