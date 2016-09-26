package com.approveproject.springmvc.service;

import java.util.List;
import java.util.Map;

import com.approveproject.springmvc.pojo.AppLeaderNameAndCategory;
import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.ApprovalVo;
import com.approveproject.springmvc.pojo.Detail;

/**
 * 申报服务接口
 * @ClassName: IUserService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午4:46:42
 */
public interface IApplicationService {
	/**
	 * 新增申请，不包括附件文件
	 * @Title: addApplication 
	 * @Description: TODO
	 * @return
	 * @return: int
	 */
	public int addApplication(Application application);
	
	/**
	 * 更新申请信息，不包括附件文件
	 * 当申请状态变更时，也调用此接口
	 * @Title: updateApplication 
	 * @Description: TODO
	 * @param application
	 * @return
	 * @return: int
	 */
	public int updateApplication(Application application);
	
	/**
	 * 根据申报的ID将申报删除
	 * @Title: deleteApplicationByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: int
	 */
	public int deleteApplicationByID(int id);
	
	
	/***
	 * 查询某 负责人 的全部项目
	 * @Title: queryApplicationByStage 
	 * @Description: TODO
	 * @return
	 * @return: List<Application>
	 */
	public List<Application> queryAllApplicationByUserID(int id) ;
	
	/**
	 * 根据一条detail记录修改申报的当前状态、审核人等信息
	 * 用于审核时，及时更新状态
	 * @Title: updateApplicationByDetail 
	 * @Description: TODO
	 * @param detail
	 * @return
	 * @return: int
	 */
	public int updateApplicationByDetail(Detail detail);
	/**
	 * 根据approvalVo 对象中的查询条件，查询出相应的记录
	 * 用于查询用户的项目、阶段、状态
	 * @Title: getAllPassedEstablishByApprovalVo 
	 * @Description: TODO
	 * @param approvalVo
	 * @return
	 * @return: List<Application>
	 */
	public List<Application> getAllEstablishedByApprovalVo(ApprovalVo approvalVo);

	
	Application getOneApp(Integer id);

	List<AppLeaderNameAndCategory> getAllEstablishedByStage(Map<String, Integer> map);

	List<AppLeaderNameAndCategory> getAllEstablishedByStatus(Map<String, Integer> map);

	List<AppLeaderNameAndCategory> getAllCanApprove(Map<String, Integer> map);

	List<AppLeaderNameAndCategory> getAllApproved(Map<String, Integer> map);

	public List getStageAndNum();

	public List getStatusAndNum();

}
