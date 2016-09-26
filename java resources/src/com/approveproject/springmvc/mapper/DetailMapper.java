package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.Detail;

public interface DetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Detail record);

    Detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Detail record);
    
    List<Detail> queryAllDetailsByAppID(Integer application_id);
}