package com.approveproject.junit.test;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.approveproject.springmvc.mapper.UserMapper;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.service.IUserService;
import com.approveproject.springmvc.service.impl.UserServiceImpl;
import com.approveproject.springmvc.utils.ReflectBean;



public class UserTest {
	private ApplicationContext applicationContext;
	private UserMapper userMapper;
	private IUserService userService;
	@org.junit.Before
	public void Init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml");
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		userService=(IUserService) applicationContext.getBean("userService");
	}
	
	@Test
	public void testInsertUser() {
		System.out.println("----testInsertUser() start");
		
		User user=new User();
		user.setGender("男");
		user.setUsername("zl113322");
		user.setPassword("lx113322");
		int line=userMapper.insertSelective(user);
		System.out.println(user);
		System.out.println("line:"+line);
		
	}
	@Test
	public void testGetAllUser(){
		List list=userService.getAllUser(1,1);
		System.out.println(list.size());
		Iterator it=list.iterator();
		while (it.hasNext()) {
			System.out.println(((User)it.next()).toString());
		}
	}
	
	@Test
	public void testReflectBean(){
		User user=null;
		try {
			//空指针异常
			user=(User) ReflectBean.getBeanFromPOST(User.class, null);
			System.out.println(user);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSelectOne() {
		User user=userService.getOneUser("zl113322","111111");
		System.out.println(user);
	}
	

}
