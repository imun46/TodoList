package com.my.todoList.category;

public interface CategoryDao {

	//카테고리 등록
	public Integer insert(Category category)throws Exception;
	
	//카테고리 이름찾기
	public String selectCategoryName(Integer categoryNo)throws Exception;
}
