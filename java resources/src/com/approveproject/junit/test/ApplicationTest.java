package com.approveproject.junit.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.approveproject.springmvc.mapper.ApplicationMapper;
import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.ApprovalVo;
import com.approveproject.springmvc.pojo.Detail;
import com.approveproject.springmvc.service.*;
import com.approveproject.springmvc.utils.DateTimeUtils;

public class ApplicationTest {

	private ApplicationContext applicationContext;
	private IApplicationService applicationService;
	private ApplicationMapper applicationMapper;
	@org.junit.Before
	public void Init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml");
		applicationService= (IApplicationService) applicationContext.getBean("applicationService");
		applicationMapper=(ApplicationMapper) applicationContext.getBean("applicationMapper");
	
	}
	
	@Test
	public void testInsert(){
		Application application = new Application();
		application.setApprover("张三");
		application.setCategory_id(1);
		application.setCreatetime(System.currentTimeMillis());
		application.setLeader_id(12);
		application.setStage(11);
		application.setStatus("0");
		application.setTopic("项目申报1");
		applicationService.addApplication(application);
		System.out.println("done!!");
	}
	@Test
	public  void queryByID(){
		List<Application> list=applicationService.queryAllApplicationByUserID(12);
		Iterator iterator=list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
			
		}
	}
	
	@Test
	public void testFindAppDetails(){
		List<Application> applications=applicationMapper.findApplicationAndDetails();
		System.out.println(new DateTimeUtils(applications.get(0).getDetails().get(0).getApprovetime()).getDate());
	}
	
	@Test
	public void testGetAllPassedEstablishByApprovalVo(){
		ApprovalVo approvalVo=new ApprovalVo();
		approvalVo.setLeader_id(12);
		approvalVo.setStage(0);
		approvalVo.setStatus("2");
		List<Application> applications=applicationMapper.getAllEstablishedByApprovalVo(approvalVo);
		if(applications==null){
			System.out.println("null");
		}
		else if(applications.isEmpty()){
			System.out.println("isEmpty");
		}
		else {
			applications.forEach(t->{
			System.out.println(t.toString());
		});
		}
		
	}
	@Test
	public void updateStatusByDetail(){
		Detail detail=new Detail();
		detail.setApplication_id(3);
		detail.setApprover_id(2);
		detail.setApprovetime(System.currentTimeMillis());
		detail.setComments("大概差不多还是不行吧");
		detail.setStatus("-1");
//		updateStatusByDetail
		System.out.println(applicationMapper.updateStatusByDetail(detail));
		
	}
	
	
}
