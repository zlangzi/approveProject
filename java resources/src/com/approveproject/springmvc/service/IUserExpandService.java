package com.approveproject.springmvc.service;

import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserExpand;

/**
 * 用户扩展数据表，用户进行身份验证的时候需要填的数据
 * @ClassName: IUserExpandService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午9:20:40
 */
public interface IUserExpandService {
	
	/**
	 * 根据用户ID插入信息，此扩展用于用户身份验证
	 * @Title: addUserExpand 
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public int  addUserExpand(UserExpand expand) throws Exception;


	/**
	 * 用户扩展信息更新
	 * @Title: updateUserExpand 
	 * @Description: TODO
	 * @param expand
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public int updateUserExpand(UserExpand expand) throws Exception;


	public UserExpand getOne(Integer id);
	
	

}
