package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.ApproveAttachment;
import com.sun.xml.internal.ws.api.message.Attachment;

public interface ApproveAttachmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApproveAttachment record);

    int insertSelective(ApproveAttachment record);

    ApproveAttachment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApproveAttachment record);

    int updateByPrimaryKey(ApproveAttachment record);
    
    ApproveAttachment selecLastestAttByID(Integer application_id);

	List<Attachment> queryAllByAppID(Integer app_id);
    
}