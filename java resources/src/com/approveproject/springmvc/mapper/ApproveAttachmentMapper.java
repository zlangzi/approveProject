package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.ApproveAttachment;

public interface ApproveAttachmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApproveAttachment record);

    int insertSelective(ApproveAttachment record);

    ApproveAttachment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApproveAttachment record);

    int updateByPrimaryKey(ApproveAttachment record);
    
    ApproveAttachment selecLastestAttByID(Integer application_id);

	List<ApproveAttachment> queryAllByAppID(Integer app_id);
    
}