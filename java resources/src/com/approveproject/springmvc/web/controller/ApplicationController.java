package com.approveproject.springmvc.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.ApprovalVo;
import com.approveproject.springmvc.pojo.Detail;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.service.IApplicationService;
import com.approveproject.springmvc.service.IDetailService;
import com.approveproject.springmvc.service.impl.ApplicationServiceImpl;

/**
 * 申报的controller
 * @ClassName: ApplicationController 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月13日 上午8:56:42
 */
@Controller("applicationController")
public class ApplicationController {
	@Inject
	private IApplicationService applicationService;
	
	@Inject
	private IDetailService detailService;
	
	@RequestMapping("newApplication")
	@ResponseBody
	public String createApp(Application application,HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		//获取当前系统时间
		application=newAppInit(application,user);
		
//		int res=1;
		int res=applicationService.addApplication(application);
		System.out.println(application);
		if(res==1){
			return application.getId().toString();
		}
		else {
			return "failed";
		}
		
		
	}
	/**
	 * 根据状态查询，与阶段无关
	 * @Title: getAPPListByStatus 
	 * @Description: TODO
	 * @param stage
	 * @param request
	 * @return
	 * @return: List<Application>
	 */
	@RequestMapping("getAPPListByStatus")
	@ResponseBody
	public List<Application> getAPPListByStatus(@RequestParam Integer status,HttpServletRequest request){
		Map<String, Integer> map=new HashMap<>();
		User user=(User) request.getSession().getAttribute("user");
		map.put("status", status);
		if(user!=null){
			map.put("user_id", user.getId());
		}
		else {
			map.put("user_id", -1);
		}
		List list=applicationService.getAllEstablishedByStatus(map);
		if ("2".equals(status.toString())) {
			map.clear();
			map.put("status", status+1);
			map.put("user_id", user.getId());
			List list2=applicationService.getAllEstablishedByStatus(map);
			for(int i=0;i<list2.size();i++){
				list.add(list2.get(i));
			}
		}
		
		System.out.println(list+"=========list");
		return list;
		
		
	}
	@RequestMapping("getApprovedByStatus")
	@ResponseBody
	public List<Application> getApprovedByStatus(@RequestParam Integer status,HttpServletRequest request){
		Map<String, Integer> map=new HashMap<>();
		User user=(User) request.getSession().getAttribute("user");
		map.put("status", status);
		if(user!=null){
			map.put("approver_id", user.getId());
		}
		else {
			map.put("approver_id", -1);
		}
		List list=applicationService.getAllApproved(map);
		
		
		System.out.println(list+"=========list");
		return list;
		
		
	}
	/**
	 * 根据阶段查询，实现下一阶段的申报，必须上一阶段status为2 ：已经通过
	 * @Title: getAPPListByStage 
	 * @Description: TODO
	 * @param stage
	 * @param request
	 * @return
	 * @return: List<Application>
	 */
	@ResponseBody
	@RequestMapping("getAPPListByStage")
	public List<Application> getAPPListByStage(@RequestParam Integer stage,HttpServletRequest request){
		Map<String, Integer> map=new HashMap<>();
		User user=(User) request.getSession().getAttribute("user");
		map.put("stage", stage);
		map.put("status", 2);
		if(user!=null){
			map.put("user_id", user.getId());
		}
		else {
			map.put("user_id", -1);
		}
	
		List list=applicationService.getAllEstablishedByStage(map);
		System.out.println(list+"=========list");
		return list;
	}
	
	@ResponseBody
	@RequestMapping("getAPPListByStage_approver")
	public List<Application> getAppListByStage(@RequestParam Integer stage,HttpServletRequest request){
		Map<String, Integer> map=new HashMap<>();
		User user=(User) request.getSession().getAttribute("user");
		map.put("stage", stage);
		map.put("status", 0);
		
		List list=applicationService.getAllCanApprove(map);
		System.out.println(list+"=========list");
		return list;
	}
	@ResponseBody
	@RequestMapping("getAPPListByStage_bg")
	public List<Application> getAppListByStage_bg(@RequestParam Integer stage,HttpServletRequest request){
		Map<String, Integer> map=new HashMap<>();
		map.put("stage", stage);
		map.put("status", 2);
		
		List list=applicationService.getAllCanApprove(map);
		map.clear();
		
		map.put("stage", stage);
		map.put("status", 3);
		List list2=applicationService.getAllCanApprove(map);
		list.addAll(list2);
		System.out.println(list+"=========list");
		return list;
	}
	
	@ResponseBody
	@RequestMapping("getOneApp")
	public Application goAppDetail(@RequestParam Integer id){
		return applicationService.getOneApp(id);
		
	}
	
	@ResponseBody
	@RequestMapping("eachNum")
	public List getEachNum(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		List list=new ArrayList<>();
		int n0,n1,n2,n3;
		n0=n1=n2=n3=0;
		List<Application> applications= applicationService.queryAllApplicationByUserID(user.getId());
		for(int i=0;i<applications.size();i++){
			switch (applications.get(i).getStatus()) {
			
			case "-1":
				n0++;
				break;
			case "0":
				n1++;
				break;
			case "1":
				n2++;
				break;
			case "2":
				n3++;
				break;
			case "3":
				n3++;
				break;
			default:
				break;
			}
		}
		list.add(n0);list.add(n1);list.add(n2);list.add(n3);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping("plsApprove")
	public String startApprove(@RequestParam Integer id,HttpServletRequest request){
		
		Application application=applicationService.getOneApp(id);
		//草稿
		if (application.getStage()==0&&application.getStatus().equals("-2")) {
			application.setStatus("0");
			return applicationService.updateApplication(application)==1?application.getId().toString():"failed";
		}
		else {
			
			Application application2=applicationService.getOneApp(id);
			application2.setId(null);
			application2.setStage(application2.getStage()+1);
			application2.setStatus("0");
			application.setStatus("3");//进行下一阶段申报
			applicationService.updateApplication(application);
			return applicationService.addApplication(application2)==1?application2.getId().toString():"failed";
		}
		
		
		
		
	}
	
	
	
	
	private Application newAppInit(Application application,User user){
		application.setCreatetime(System.currentTimeMillis());
		application.setStage(0);
		application.setStatus("-2");
		//获取当前用户session，根据session设置申请人
		
		application.setLeader_id(user.getId());
		
		return application;
	}
}
