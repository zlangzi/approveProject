package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    Category selectByPrimaryKey(Integer id);
    
    List<Category> getAllCategory();
    int updateByPrimaryKey(Category record);
}