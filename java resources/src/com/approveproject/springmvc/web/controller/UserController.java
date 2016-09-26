package com.approveproject.springmvc.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.Role;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserExpand;
import com.approveproject.springmvc.pojo.UserInfoVo;
import com.approveproject.springmvc.service.IUserExpandService;
import com.approveproject.springmvc.service.IUserService;
import com.approveproject.springmvc.service.impl.UserExpandService;
import com.approveproject.springmvc.utils.ReflectBean;

import sun.rmi.log.LogOutputStream;
/**
 * 视图图解析器 
 * 处理器映射器
 * 前端控制器
 * 处理器适配器
 */

/**
 * 
 */
//@RequestMapping("/user")
@Controller("userController")
public class UserController{
	
	@Inject
	private IUserService userService;
	@Inject
	private IUserExpandService userExpandService;
	
	//用户身份申请
	@RequestMapping("getUserApp")
	@ResponseBody
	public List getUserApp(@RequestParam String status){
		
		return  userService.getUsersByStatus( status);
		
	}
	
	@RequestMapping("checkUsername")
	@ResponseBody
	public String isExists(@RequestParam String username){
		
		User user= userService.getOneUser(username);
		if(user!=null){
			return "failed";
		}
		return "OK";
		
	}
	@RequestMapping("getSession")
	@ResponseBody
	public Map getSessionUser(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		UserExpand expand=null;
		Map map=new HashMap<>();
		if(user!=null){
			if(user.getRole_id()!=null){
				if(user.getRole_id()!=1)
					expand= userExpandService.getOne(user.getId());
			}
			map.put("expand", expand);
		}
		map.put("user", user);
		
		return map;
	}
	
	@ResponseBody
	//register.action
	@RequestMapping("register")
	public String register( User user, HttpServletRequest request)   {
		System.out.println("---->registing!");
		try {
			userService.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "failed";
			
		}
		System.out.println("user:"+user);
		request.getSession().setAttribute("user", user);
		return "success";//success.jsp
	}
	@ResponseBody
	@RequestMapping("login")
	public User login(@RequestParam String usernameLog,@RequestParam String passwordLog,HttpServletRequest request)  {
		System.out.println(usernameLog+":"+passwordLog);
		User user=userService.getOneUser(usernameLog,passwordLog);
		System.out.println(user);
		request.getSession().setAttribute("user", user);
		System.out.println(user+"login---");
//		return "redirect:listUser.action";
		return user;
	}
	@RequestMapping("logout")
	@ResponseBody
	public void logout(HttpServletRequest request){
		
		request.getSession().removeAttribute("user");
		
	}
	
	
	
	
	
	
	
	//由于在applicationContext-mvc.xml中配置了SimpleMappingExceptionResolver，则此处不再起作用�?
//	@ExceptionHandler(RuntimeException.class)
//	public String exceptionHandler(){
//		System.out.println("The UserController throws an Exception...");
//		return "errorPage";
//	}
	
	
	@RequestMapping("userInfo")
	 @ResponseBody
	 public UserInfoVo getUserInfo(HttpServletRequest request){
		 UserInfoVo info=new UserInfoVo();
		 User user=(User)request.getSession().getAttribute("user");
		 if(user.getRole_id() != null){
			 info=userService.getfullUserInfo(user.getId());
		 }
		 else {
			 info.setEmail(user.getEmail());
			 info.setGender(user.getGender());
			 info.setId(user.getId());
			 info.setIdcard(user.getIdcard());
			 info.setName(user.getName());
			 info.setPhone(user.getPhone());
			 info.setUsername(user.getUsername());
			info.setRole(new Role());
			info.setUserExpand(new UserExpand());
		}
		
		
		 System.out.println(info);
		 
		 return info;
		 
	 }
	 @RequestMapping("updateUserRoleStatus")
	 @ResponseBody
	 public String updateUserRoleStatus(Integer id,String status ) throws Exception{
		
		 UserExpand expand =userExpandService.getOne(id);
		 expand.setPassed(status);
		
		 return userExpandService.updateUserExpand(expand )!=1?"failed":"success";
		 
	 }
	 
}
