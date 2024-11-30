package com.my.todoList.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	/*카테고리 등록*/
	public Integer createCategory(Category category) throws Exception{
		return categoryDao.insert(category);
	}
	
	/*카테고리 이름 찾기*/
	public String selectCategoryName(Integer categoryNo) throws Exception{
		return categoryDao.selectCategoryName(categoryNo);
	}
	
}
