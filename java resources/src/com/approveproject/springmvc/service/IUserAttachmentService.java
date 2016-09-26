package com.approveproject.springmvc.service;

import com.approveproject.springmvc.pojo.UserAttachment;
/**
 * 附件上传的服务接口定义
 * 用户身份验证的附件上传共用的接口
 * @ClassName: AttachmentUploadService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午4:43:59
 */
public interface IUserAttachmentService {
	/**
	 * 将上传的附件保存起来
	 * @Title: saveAttachment 
	 * @Description: TODO
	 * @param attachment
	 * @return
	 * @return: int
	 */
	public int addAttachment(UserAttachment attachment);
	
	/**
	 * 根据ID查询附件
	 * @Title: getAttachmentByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: UserAttachment
	 */
	public UserAttachment getAttachmentByID(int id);

	/**
	 * 根据ID修改附件基本内容
	 * 并覆盖附件文件（先上传新的再删除旧的）
	 * @Title: updateAttachment 
	 * @Description: TODO
	 * @param attachment
	 * @return: int
	 */
	public int updateAttachment(UserAttachment attachment);

	/**
	 * 根据id删除附件
	 * 删除数据库中的记录和服务器中保存的文件
	 * @Title: deleteAttachmentByID 
	 * @Description: TODO
	 * @param id
	 * @return: int
	 */
	public int deleteAttachmentByID(int id);
	
}
