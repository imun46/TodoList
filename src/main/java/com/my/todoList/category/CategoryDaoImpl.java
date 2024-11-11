package com.my.todoList.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.todoList.category.mapper.CategoryMapper;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public Integer insert(Category category) throws Exception {
		return categoryMapper.insert(category);
	}

}
