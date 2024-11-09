package com.my.todoList.user;

public interface UserDao {
	
	//회원가입
	public int insert(Users user) throws Exception;
	//회원수정
	public int update(Users user) throws Exception;
	//회원조회(마이페이지)
	public Users select(Integer userNo) throws Exception;
	//회원탈퇴
	public int delete(Integer UserNo) throws Exception;
	
}
