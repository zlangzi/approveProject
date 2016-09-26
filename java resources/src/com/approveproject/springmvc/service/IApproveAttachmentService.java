package com.approveproject.springmvc.service;

import java.util.List;

import com.approveproject.springmvc.pojo.ApproveAttachment;
import com.sun.xml.internal.ws.api.message.Attachment;
/**
 * 附件上传的服务接口定义
 * 项目审核的附件上传共用接口
 * @ClassName: AttachmentUploadService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午4:43:59
 */
public interface IApproveAttachmentService {
	/**
	 * 将上传的附件保存起来
	 * @Title: saveAttachment 
	 * @Description: TODO
	 * @param attachment
	 * @return
	 * @return: int
	 */
	public int addAttachment(ApproveAttachment attachment);
	
	/**
	 * 根据ID查询附件
	 * @Title: getAttachmentByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: String
	 */
	public ApproveAttachment getAttachmentByID(int id);

	/**
	 * 根据ID修改附件表内容
	 * 主要用来修改path
	 * @Title: updateAttachment 
	 * @Description: TODO
	 * @param attachment
	 * @return: int
	 */
	public int updateAttachment(ApproveAttachment attachment);

	/**
	 * 根据id删除附件
	 * @Title: deleteAttachmentByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: int
	 */
	public int deleteAttachmentByID(int id);

	ApproveAttachment selecLastestAttByID(Integer application_id);

	public List<Attachment> queryAllByAppID(Integer app_id);

	public ApproveAttachment selecOneByID(Integer id);
	
}
