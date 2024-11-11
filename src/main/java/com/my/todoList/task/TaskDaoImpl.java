package com.my.todoList.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private TaskDao taskDao;
	
	@Override
	public Integer insert(Task task) throws Exception {
		return taskDao.insert(task);
	}

	@Override
	public Integer delete(Integer taskNo) throws Exception {
		return taskDao.delete(taskNo);
	}

	@Override
	public Integer update(Task task) throws Exception {
		return taskDao.update(task);
	}

	@Override
	public Task selectBytaskNo(Integer taskNo) throws Exception {
		return taskDao.selectBytaskNo(taskNo);
	}

	@Override
	public List<Task> selectByUserNo(Integer userNo) throws Exception {
		return taskDao.selectByUserNo(userNo);
	}

}
