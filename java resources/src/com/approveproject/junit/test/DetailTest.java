package com.approveproject.junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.approveproject.springmvc.mapper.ApplicationMapper;
import com.approveproject.springmvc.pojo.Detail;
import com.approveproject.springmvc.service.IApplicationService;
import com.approveproject.springmvc.service.IDetailService;

public class DetailTest {

	private ApplicationContext applicationContext;
	private IDetailService detailService;
	
	@org.junit.Before
	public void Init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml");
		detailService= (IDetailService) applicationContext.getBean("detailService");
	
	}
	@Test
	public void testQuery(){
		
		List<Detail> list=detailService.queryAllDetailsByAppID(1);
		System.out.println(list);
	}
}
