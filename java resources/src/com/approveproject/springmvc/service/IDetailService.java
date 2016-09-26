package com.approveproject.springmvc.service;

import java.util.List;

import com.approveproject.springmvc.pojo.Detail;

/**
 * 审核明细服务接口定义
 * @ClassName: IDetailService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月13日 上午10:24:40
 */

public interface IDetailService {

	/**
	 * 添加新的审核明细
	 * @Title: addDetail 
	 * @Description: TODO
	 * @param detail
	 * @return
	 * @return: int
	 */
	public int addDetail(Detail detail);
	
	
	/**
	 * 根据ID删除某条审核明细记录
	 * @Title: deleteDetailByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: int
	 */
	public int deleteDetailByID(int id);
	
	/**
	 * 根据传入的Detail对象进行更新
	 * 审核的通过和驳回可以使用
	 * @Title: updateDetailByID 
	 * @Description: TODO
	 * @param detail
	 * @return
	 * @return: int
	 */
	public int updateDetailByID (Detail detail) ;
	
	/**
	 * 根据申报ID查询所有的Detail
	 * @Title: queryAllDetailsByAppID 
	 * @Description: TODO
	 * @param app_id
	 * @return
	 * @return: List<Detail>
	 */
	public List<Detail> queryAllDetailsByAppID(int app_id) ;
	
	
}
