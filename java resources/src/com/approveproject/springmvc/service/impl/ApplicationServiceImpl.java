package com.approveproject.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.ApplicationMapper;
import com.approveproject.springmvc.pojo.AppLeaderNameAndCategory;
import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.ApprovalVo;
import com.approveproject.springmvc.pojo.Detail;
import com.approveproject.springmvc.service.IApplicationService;
/**
 * 申报服务实现类
 * @ClassName: ApplicationServiceImpl 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月12日 上午10:40:46
 */
@Service("applicationService")
public class ApplicationServiceImpl implements IApplicationService {
	
	@Inject
	private ApplicationMapper applicationMapper;
	
	
	@Override
	public int addApplication(Application application) {
		// TODO Auto-generated method stub
		return applicationMapper.insertSelective(application);
	}
	
	
	@Override
	public int updateApplication(Application application) {
		// TODO Auto-generated method stub
		return applicationMapper.updateByPrimaryKeySelective(application);
	}

	@Override
	public int deleteApplicationByID(int id) {
		// TODO Auto-generated method stub
		
		return applicationMapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<Application> queryAllApplicationByUserID(int id) {
		// TODO Auto-generated method stub
		return applicationMapper.queryAllApplicationByUserID(id);
	}


	@Override
	public int updateApplicationByDetail(Detail detail) {
		// TODO Auto-generated method stub
		return applicationMapper.updateStatusByDetail(detail);
	}


	@Override
	public List<Application> getAllEstablishedByApprovalVo(ApprovalVo approvalVo) {
		// TODO Auto-generated method stub
		return applicationMapper.getAllEstablishedByApprovalVo(approvalVo);
	}
	
	@Override
	public List<AppLeaderNameAndCategory> getAllEstablishedByStage(Map<String,Integer> map){
		
		return applicationMapper.getAllEstablishedByStage(map);
	}


	@Override
	public Application getOneApp(Integer id) {
		// TODO Auto-generated method stub
		return applicationMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<AppLeaderNameAndCategory> getAllEstablishedByStatus(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		
		
		return applicationMapper.getAllEstablishedByStatus(map);
	}
	@Override
	public List<AppLeaderNameAndCategory> getAllCanApprove(Map<String, Integer> map) {
		
		return applicationMapper.getAllCanApprove(map);
	}
	
	@Override
	public List<AppLeaderNameAndCategory> getAllApproved(Map<String, Integer> map) {
		
		return applicationMapper.getAllApproved(map);
	}


	@Override
	public List getStageAndNum() {
		// TODO Auto-generated method stub
		return applicationMapper.getStageAndNum();
	}


	@Override
	public List getStatusAndNum() {
		// TODO Auto-generated method stub
		return applicationMapper.getStatusAndNum();
	}
	
		
		
}
