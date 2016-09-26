package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.UserExpand;

public interface UserExpandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserExpand record);


    UserExpand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserExpand record);

    int updateByPrimaryKey(UserExpand record);

}