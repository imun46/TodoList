package com.my.todoList.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.todoList.task.mapper.TaskMapper;

@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private TaskMapper taskMapper;
	
	@Override
	public Integer insert(Task task) throws Exception {
		return taskMapper.insert(task);
	}

	@Override
	public Integer delete(Integer taskNo) throws Exception {
		return taskMapper.delete(taskNo);
	}

	@Override
	public Integer update(Task task) throws Exception {
		return taskMapper.update(task);
	}

	@Override
	public Task selectByTaskNo(Integer taskNo) throws Exception {
		return taskMapper.selectByTaskNo(taskNo);
	}

	@Override
	public List<Task> selectByUserNo(Integer userNo) throws Exception {
		return taskMapper.selectByUserNo(userNo);
	}

}
