package com.my.todoList.task;

@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private TaskDao taskDao;
	
	@Override
	public int insert(Task task) throws Exception {
		return taskDao.insert(task);
	}

	@Override
	public int delete(Integer taskNo) throws Exception {
		return taskDao.delete(taskNo);
	}

	@Override
	public int update(Task task) throws Exception {
		return taskDao.update(task);
	}

	@Override
	public int selectBytaskNo(Integer taskNo) throws Exception {
		return taskDao.selectBytaskNo(taskNo);
	}

	@Override
	public int selectByUserNo(Integer userNo) throws Exception {
		return taskDao.selectByUserNo(userNo);
	}

}
