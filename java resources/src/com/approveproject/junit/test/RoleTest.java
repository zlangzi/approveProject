package com.approveproject.junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.approveproject.springmvc.service.IRoleService;

public class RoleTest {
	private ApplicationContext applicationContext;
	private IRoleService roleService;
	
	@org.junit.Before
	public void Init(){
		applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml");
		roleService=(IRoleService) applicationContext.getBean("roleService");
	}
	@Test
	public void testGetAllRole() throws Exception{
		System.out.println(roleService.getAllRole(1, 1));
	}
}
