package com.my.todoList.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.my.todoList.role.UserRoles;
import com.my.todoList.user.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserMapper userMapper;
	
	public UserDaoImpl() {

	}

	@Override
	public Integer insert(Users user) throws Exception {
		int rowCount = userMapper.insert(user);
		for(UserRoles userRole: user.getUserRoles()) {
			userMapper.insertUserRole(userRole);
		}
 		return rowCount;
	}

	@Override
	public Integer update(Users user) throws Exception {
		return userMapper.update(user);
	}

	/* UserDetails 구현체 */
	@Override
	public Integer delete(Integer UserNo) throws Exception {
		return userMapper.delete(UserNo);
	}
	@Override
	public Users selectUserByNo(Integer userNo) throws Exception {
		return userMapper.selectUserByNo(userNo);
	}

	@Override
	public Users selectUserById(String id) throws Exception {
		return userMapper.selectUserById(id);
	}
	
}
