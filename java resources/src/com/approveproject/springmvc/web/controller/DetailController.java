package com.approveproject.springmvc.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.Detail;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.service.IApplicationService;
import com.approveproject.springmvc.service.IDetailService;

/**
 * 审核明细控制器
 * 开始审核--审核中 1
 * 通过-----通过    2
 * 驳回-----不通过-1
 * 
 * @ClassName: DetailController 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月13日 上午10:31:08
 */
@Controller("detailController")
public class DetailController {
	@Inject
	IDetailService detailService;
	
	@Inject
	private IApplicationService applicationService;

	
	/**
	 * 进行审核，既是新增一条审核明细
	 * @Title: doApprove 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("startApprove")
	public String startApprove_approver(@RequestParam Integer id,HttpServletRequest request){
		Detail detail=new Detail();
		User user = (User) request.getSession().getAttribute("user");
		
		detail.setApplication_id(id);
		detail.setApprover_id(user.getId());
		detail.setApprovetime(System.currentTimeMillis());
		detail.setStatus("1");
		detail.setComments("开始审核");
		if(detailService.addDetail(detail)==1){
			Application application=applicationService.getOneApp(id);
			application.setStatus(detail.getStatus());
			application.setApprover(detail.getApprover_id().toString());
			applicationService.updateApplication(application);
		}
		else {
			return "failed";
		}
		
		
		return "success";
		
	}
	@ResponseBody
	@RequestMapping("finishApprove")
	public String finishApprove(String comments,String status,Integer application_id, HttpServletRequest request){
		Detail detail=new Detail();
		User user = (User) request.getSession().getAttribute("user");
		
		detail.setApplication_id(application_id);
		detail.setApprover_id(user.getId());
		detail.setApprovetime(System.currentTimeMillis());
		detail.setStatus(status);
		
		detail.setComments(comments);
		if(detailService.addDetail(detail)==1){
			
			Application application=applicationService.getOneApp(application_id);
			application.setStatus(detail.getStatus());
			application.setApprover(detail.getApprover_id().toString());
			applicationService.updateApplication(application);
		}
		else {
			return "failed";
		}
		
		
		return "success";
	}
	

		@ResponseBody
		@RequestMapping("getApproveDetails")
		public List<Detail> getApproveDetails(Integer app_id){
			
			return detailService.queryAllDetailsByAppID(app_id);
			
		}
	
}
