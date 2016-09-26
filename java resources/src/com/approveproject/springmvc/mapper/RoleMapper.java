package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

   

    Role selectByPrimaryKey(Integer id);

    

    int updateByPrimaryKey(Role record);

	List<Role> getAllRole(Integer page, Integer pageCount);
}