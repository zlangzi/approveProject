package com.approveproject.springmvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.ApproveAttachmentMapper;
import com.approveproject.springmvc.pojo.ApproveAttachment;
import com.approveproject.springmvc.pojo.UserAttachment;
import com.approveproject.springmvc.service.IApproveAttachmentService;
import com.approveproject.springmvc.service.IUserAttachmentService;
import com.sun.xml.internal.ws.api.message.Attachment;
/**
 * 申报审核附件上传接口实现类
 * @ClassName: ApproveAttachmentServiceImpl 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月13日 上午8:59:49
 */
@Service("approveAttachmentService")
public class ApproveAttachmentServiceImpl implements IApproveAttachmentService {

	@Inject
	ApproveAttachmentMapper approveAttachmentMapper;
	
	@Override
	public int addAttachment(ApproveAttachment attachment) {
		// TODO Auto-generated method stub
		return approveAttachmentMapper.insertSelective(attachment);
	}

	@Override
	public ApproveAttachment getAttachmentByID(int id) {
		// TODO Auto-generated method stub
		return approveAttachmentMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public int updateAttachment(ApproveAttachment attachment) {
		// TODO Auto-generated method stub
		return approveAttachmentMapper.updateByPrimaryKeySelective(attachment);
	}

	@Override
	public int deleteAttachmentByID(int id) {
		// TODO Auto-generated method stub
		return approveAttachmentMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public ApproveAttachment selecLastestAttByID(Integer application_id){
		
		return approveAttachmentMapper.selecLastestAttByID(application_id);
	}

	@Override
	public List<Attachment> queryAllByAppID(Integer app_id) {
		// TODO Auto-generated method stub
		return approveAttachmentMapper.queryAllByAppID(app_id);
	}

	@Override
	public ApproveAttachment selecOneByID(Integer id) {
		// TODO Auto-generated method stub
		return approveAttachmentMapper.selectByPrimaryKey(id);
	}

}
