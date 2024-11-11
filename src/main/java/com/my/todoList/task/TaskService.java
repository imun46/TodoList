package com.my.todoList.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	/*할일 저장*/
	public Integer createTask(Task task) throws Exception {
		return taskDao.insert(task);
	}
	/*할일 삭제*/
	public Integer deleteTask(Integer taskNo) throws Exception{
		return taskDao.delete(taskNo);
	}
	/*할일 수정*/
	public Integer update(Task task) throws Exception{
		return taskDao.update(task);
	}
	/*할일 출력 특정 pk 한개*/
	public Task findTaskByTaskNo(Integer TaskNo) throws Exception{
		return taskDao.selectByTaskNo(TaskNo);
	}
	
	/*할일 전체 출력 (특정 유저)*/
	public List<Task> findTaskByUserNo(Integer UserNo) throws Exception{
		return taskDao.selectByUserNo(UserNo);
	}
}
