package com.approveproject.springmvc.service;

import java.util.List;

import com.approveproject.springmvc.pojo.Category;

/**
 * 项目类别服务接口
 * @ClassName: ICategoryService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月21日 下午2:02:10
 */
public interface ICategoryService {

		public List<Category> getAllCategory();
		
		/**
		 * 新增一个类型
		 * @Title: addOneCategory 
		 * @Description: TODO
		 * @param parent_id
		 * @return
		 * @return: Integer
		 */
		public Integer addOneCategory(Category category);
		
		
		public int delOneCategoryByID(Integer id);
		
		
}
