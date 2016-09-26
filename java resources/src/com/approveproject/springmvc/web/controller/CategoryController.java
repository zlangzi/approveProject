package com.approveproject.springmvc.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.Category;
import com.approveproject.springmvc.service.ICategoryService;

/**
 * 
 * @ClassName: CategoryController 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月21日 下午2:13:26
 */
@Controller
public class CategoryController {
	
	@Inject
	private ICategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("getCategorys")
	public List<Category> getAllCategory(){
		System.out.println("in -category");
		return categoryService.getAllCategory();
		
	}
	@RequestMapping("newCategory")
	@ResponseBody
	public String newCategory(Category category){
		System.out.println(category);
		return "";
	}
}
