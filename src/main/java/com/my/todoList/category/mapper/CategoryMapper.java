package com.my.todoList.category.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.my.todoList.category.Category;

@Mapper
public interface CategoryMapper {
	//카테고리 등록
		public Integer insert(Category category)throws Exception;
		
}