package com.my.todoList.user;

import java.util.List;

public interface UserDao {
	
	//회원가입
	public Integer insert(Users user) throws Exception;
	//회원수정
	public Integer update(Users user) throws Exception;
	//회원조회(마이페이지)
	public Users selectUserByNo(Integer userNo) throws Exception;
	//회원탈퇴
	public Integer delete(Integer UserNo) throws Exception;
	
	//아이디로 객체 찾기
	public Users selectUserById(String id) throws Exception;
	
	//유저 전체 출력
	public List<Users> selectUserAll() throws Exception;
}
