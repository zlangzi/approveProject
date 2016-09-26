package com.approveproject.springmvc.mapper;

import java.util.List;
import java.util.Map;

import com.approveproject.springmvc.pojo.AppLeaderNameAndCategory;
import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.ApprovalVo;
import com.approveproject.springmvc.pojo.Detail;

public interface ApplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Application record);

    int insertSelective(Application record);

    Application selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);
    
    /**
     * 审核，并修改application的字段
     * @Title: updateStatusByDetail 
     * @Description: TODO
     * @param detail
     * @return
     * @return: int
     */
    int updateStatusByDetail(Detail detail);
    List<Application> queryAllApplicationByUserID(int id);
   
    /**
     * 传入leader_id,stage,status进行查询
     * 返回leader_id 的stage申报的status=2application
     * @Title: getAllPassedEstablishByApprovalVo 
     * @Description: TODO
     * @param approvalVo
     * @return
     * @return: List<Application>
     */
    List<Application> getAllEstablishedByApprovalVo(ApprovalVo approvalVo);
    /**
     * 查询一个审批的多个明细，返回在审批对象的list属性中1：n	
     * @Title: findApplicationAndDetails 
     * @Description: TODO
     * @return
     * @return: List<Application>
     */
    List<Application> findApplicationAndDetails();
    
    List<AppLeaderNameAndCategory> getAllEstablishedByStage(Map<String, Integer> map);

	List<AppLeaderNameAndCategory> getAllEstablishedByStatus(Map<String, Integer> map);
	List<AppLeaderNameAndCategory> getAllCanApprove(Map<String, Integer> map);
	
	List<AppLeaderNameAndCategory> getAllApproved(Map<String, Integer> map);

	List getStageAndNum();

	List getStatusAndNum();

}