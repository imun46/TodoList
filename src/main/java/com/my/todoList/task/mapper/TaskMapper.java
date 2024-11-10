package com.my.todoList.task.mapper;

import com.my.todoList.task.Task;

public interface TaskMapper {
	//할일 추가 
	public int insert(Task task) throws Exception;
	//할일 삭제
	public int delete(Integer taskNo) throws Exception;
	//할일 수정
	public int update(Task task) throws Exception;
	//할일 1개 출력
	public int selectBytaskNo(Integer taskNo) throws Exception;
	//특정 회원할일 출력
	public int selectByUserNo(Integer userNo) throws Exception;
}
