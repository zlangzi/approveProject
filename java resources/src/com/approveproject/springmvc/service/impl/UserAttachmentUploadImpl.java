package com.approveproject.springmvc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.UserAttachmentMapper;
import com.approveproject.springmvc.pojo.UserAttachment;
import com.approveproject.springmvc.service.IUserAttachmentService;
/**
 * 用户身份审核的附件上传
 * @ClassName: UserAttachmentUpload 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月9日 上午10:51:33
 */
@Service("userAttachmentService")
public class UserAttachmentUploadImpl implements IUserAttachmentService {

	@Inject
	private UserAttachmentMapper userAttachmentMapper;
	
	@Override
	public int addAttachment(UserAttachment attachment) {
		// TODO Auto-generated method stub
		return userAttachmentMapper.insertSelective(attachment);
	}
	@Override
	public UserAttachment getAttachmentByID(int id) {
		// TODO Auto-generated method stub
		return userAttachmentMapper.selectByPrimaryKey(id);
	}



	@Override
	public int updateAttachment(UserAttachment attachment) {
		// TODO Auto-generated method stub
		return userAttachmentMapper.updateByPrimaryKey(attachment);
	}



	@Override
	public int deleteAttachmentByID(int id) {
		// TODO Auto-generated method stub
		return userAttachmentMapper.deleteByPrimaryKey(id);
	}




	

}
