package com.approveproject.springmvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.CategoryMapper;
import com.approveproject.springmvc.pojo.Category;
import com.approveproject.springmvc.service.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	
	@Inject
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.getAllCategory();
	}

	@Override
	public Integer addOneCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(category);
	}

	@Override
	public int delOneCategoryByID(Integer id) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteByPrimaryKey(id);
	}

}
