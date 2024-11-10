package com.my.todoList.category.mapper;

import com.my.todoList.category.Category;

public interface CateogoryMapper {
	//카테고리 등록
		public Integer insert(Category category)throws Exception;
		
}
