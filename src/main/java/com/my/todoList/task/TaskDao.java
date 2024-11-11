package com.my.todoList.task;

import java.util.List;

public interface TaskDao {
	//할일 추가 
	public Integer insert(Task task) throws Exception;
	//할일 삭제
	public Integer delete(Integer taskNo) throws Exception;
	//할일 수정
	public Integer update(Task task) throws Exception;
	//할일 1개 출력
	public Task selectByTaskNo(Integer taskNo) throws Exception;
	//특정 회원할일 출력
	public List<Task> selectByUserNo(Integer userNo) throws Exception;
}
