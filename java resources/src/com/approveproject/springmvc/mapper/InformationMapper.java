package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.InfoPublisherCategory;
import com.approveproject.springmvc.pojo.Information;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKeyWithBLOBs(Information record);

    List<Information> getAllInfosByTypeID(Integer type_id);

	List<Information> getAllInfos();
    
	List<InfoPublisherCategory> getInfoCategoryByStatus(Integer status);

	List<Information> getAllInfosByStatus(String status);
}