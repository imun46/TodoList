package com.my.todoList.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Integer insert(Category category) throws Exception {
		return categoryDao.insert(category);
	}

}
