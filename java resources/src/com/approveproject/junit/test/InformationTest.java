package com.approveproject.junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.approveproject.springmvc.mapper.InformationMapper;
import com.approveproject.springmvc.pojo.Information;
import com.approveproject.springmvc.service.IInformationService;
import com.approveproject.springmvc.utils.DateTimeUtils;

public class InformationTest {

	private ApplicationContext applicationContext;
	private InformationMapper informationMapper;
	private IInformationService informationService;
	@org.junit.Before
	public void Init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml");
		informationMapper = (InformationMapper) applicationContext.getBean("informationMapper");
		informationService= (IInformationService) applicationContext.getBean("informationService");
	}
	
	@Test
	public void testInsert(){
		Information info = new Information();
		info.setContent("不更新");
		info.setPublisher_id(110);
		info.setPublishtime(System.currentTimeMillis());
		info.setStatus("0");
		info.setTitle("东方不败的青春故事");
		info.setType_id(22);
		try {
			informationService.addInfo(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetbyID(){
		Information information;
		try {
			information=informationService.getInfoByID(2);
			System.out.println(new DateTimeUtils(information.getPublishtime()).getDateTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testGetbyTpyeID(){
		List<Information> informations;
		try {
			informations=informationService.getInfosByTypeID(2, 2, 2);
			System.out.println(informations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
