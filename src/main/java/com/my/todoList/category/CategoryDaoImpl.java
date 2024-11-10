package com.my.todoList.category;

@Reapository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Integer insert(Category category) throws Exception {
		return categoryDao.insert(category);
	}

}
