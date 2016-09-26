package com.approveproject.springmvc.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserExpand;
import com.approveproject.springmvc.service.IUserExpandService;
import com.approveproject.springmvc.service.IUserService;

@Controller
public class UserExpandController {
	
	@Inject
	private IUserExpandService userExpandService;
	@Inject
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping("addExpandUserInfo")
	public String  addExpandInfo(UserExpand userExpandInfo,Integer indentify,HttpServletRequest request) throws Exception{
		User user=(User) request.getSession().getAttribute("user");
		System.out.println(indentify);;
		userExpandInfo.setId(user.getId());
		userExpandInfo.setPassed("0");
		int num=userExpandService.addUserExpand(userExpandInfo);
		System.out.println(num);
		if(num==1){
			user.setRole_id(userExpandInfo.getRole_id());
			userService.updateUser(user);
		}
		
		
		return num==1?String.valueOf(num):"failed";
	}
	
	@ResponseBody
	@RequestMapping("passIt")
	public String passIt(){
		
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("disPassIt")
	public String disPassIt(){
		
		
		return "";
	}
	
	
	
	
}
