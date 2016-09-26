package com.approveproject.springmvc.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.InfoType;
import com.approveproject.springmvc.pojo.Information;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.service.IInfoTypeService;
import com.approveproject.springmvc.service.IInformationService;

/**
 * information控制器
 * @ClassName: InformationController 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月19日 下午4:24:53
 */
@Controller
public class InformationController {
	
	@Inject
	IInformationService informationService;
	@Inject
	IInfoTypeService  infoTypeService;
	
	@RequestMapping("getAllInfos")
	@ResponseBody
	public List<Information> getAllInfos() throws Exception{
		
		
		
		return informationService.getAllInfos(0,0);
	}
	
	
	@RequestMapping("getInfoType")
	@ResponseBody
	public List<InfoType> getInfoType(){
		
		
		return infoTypeService.getInfoTypes();
	}
	
	@RequestMapping("saveAsDraft")
	@ResponseBody
	public String saveAsDraft(String title,String content,Integer type_id,HttpServletRequest request) throws Exception{
		Information info =new Information();
		User user=(User) request.getSession().getAttribute("user");
		info.setContent(content);
		info.setTitle(title);
		info.setType_id(type_id);
		info.setStatus("-2");//草稿箱
		info.setPublisher_id(user.getId());
		
		return informationService.addInfo(info)==1?info.getId().toString():"failed";
	}
	
	@RequestMapping("getInfoDetail")
	@ResponseBody
	public Information getInfoDetail(Integer id,HttpServletRequest request) throws Exception{
		
		
		
		return informationService.getInfoByID(id);
	}
	
	@RequestMapping("updateDraft")
	@ResponseBody
	public String updateDraft(Integer id,String title,String content,Integer type_id,HttpServletRequest request) throws Exception{
		
		Information information=informationService.getInfoByID(id);
		information.setTitle(title);
		information.setContent(content);
		information.setType_id(type_id);
		
		int num=informationService.updateInfo(information);
		
		return num==1? information.getId().toString():"failed";
	}
	
	@RequestMapping("newAsDraftAndPub")
	@ResponseBody
	public String newAsDraftAndPub(String title,String content,Integer type_id,HttpServletRequest request) throws Exception{
		User user=(User) request.getSession().getAttribute("user");
		Information information=new Information();
		information.setTitle(title);
		information.setContent(content);
		information.setType_id(type_id);
		information.setPublisher_id(user.getId());
		information.setPublishtime(System.currentTimeMillis());
		information.setStatus("1");//发布状态
		int num=informationService.addInfo(information);
		
		return num==1? information.getId().toString():"failed";
	}
	
	@RequestMapping("publishByID")
	@ResponseBody
	public String publishByID(Integer id,String title,String content,Integer type_id,HttpServletRequest request) throws Exception{
		User user=(User) request.getSession().getAttribute("user");
		Information information=informationService.getInfoByID(id);
		information.setTitle(title);
		information.setContent(content);
		information.setType_id(type_id);
		information.setPublisher_id(user.getId());
		information.setPublishtime(System.currentTimeMillis());
		information.setStatus("1");//发布状态
		int num=informationService.updateInfo(information);
		
		return num==1? information.getId().toString():"failed";
	}
	@RequestMapping("getInfoCategoryByStatus")
	@ResponseBody
	public List getInfoCategoryByStatus(Integer status,HttpServletRequest request) throws Exception{
		
		
		return informationService.getInfoCategoryByStatus(status);
	}
	
	@RequestMapping("delInfoByID")
	@ResponseBody
	public String delInfoByID(Integer id,HttpServletRequest request) throws Exception{
		
		
		return informationService.delInfoByID(id)!=1?"failed":"success";
	}
	
	@RequestMapping("publishInfoByID")
	@ResponseBody
	public String publishInfoByID(Integer id,HttpServletRequest request) throws Exception{
		Information info=informationService.getInfoByID(id);
		info.setStatus("1");//发布
		User user =(User) request.getSession().getAttribute("user");
		info.setPublisher_id(user.getId());
		info.setPublishtime(System.currentTimeMillis());
		return informationService.updateInfo(info)!=1?"failed":"success";
	}
	
}
