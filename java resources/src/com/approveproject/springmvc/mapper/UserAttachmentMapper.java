package com.approveproject.springmvc.mapper;

import com.approveproject.springmvc.pojo.UserAttachment;

public interface UserAttachmentMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(UserAttachment record);

    UserAttachment selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(UserAttachment record);
}