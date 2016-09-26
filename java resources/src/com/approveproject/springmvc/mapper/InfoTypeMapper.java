package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.InfoType;

public interface InfoTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InfoType record);

    int insertSelective(InfoType record);

    InfoType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InfoType record);

    int updateByPrimaryKey(InfoType record);

	List<InfoType> getInfoTypes();
}