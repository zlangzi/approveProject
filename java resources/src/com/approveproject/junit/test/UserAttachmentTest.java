package com.approveproject.junit.test;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.approveproject.springmvc.mapper.UserAttachmentMapper;
import com.approveproject.springmvc.mapper.UserMapper;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserAttachment;
import com.approveproject.springmvc.service.IUserService;
import com.approveproject.springmvc.service.impl.UserServiceImpl;
import com.approveproject.springmvc.utils.ReflectBean;



public class UserAttachmentTest {
	private ApplicationContext applicationContext;
	private UserAttachmentMapper userAttachmentMapper;
	private IUserService userService;
	@org.junit.Before
	public void Init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml");
		userAttachmentMapper = (UserAttachmentMapper) applicationContext.getBean("userAttachmentMapper");
	}
	
	@Test
	public void testInsertUserAttachment() {
		System.out.println("----testInsertUser() start");
		UserAttachment attachment=new UserAttachment();
		attachment.setPerson_id(110);
		attachment.setType("各种");
		
		attachment.setUploadtime(System.currentTimeMillis());
		
		int line=userAttachmentMapper.insertSelective(attachment);
		System.out.println("line:"+line);
		
	}
	@Test
	public void testQueryUserAttachment() {
		System.out.println("----testQueryUserAttachment() start");
		UserAttachment attachment=new UserAttachment();
		 attachment=userAttachmentMapper.selectByPrimaryKey(4);
		 
		 Date date = new Date(attachment.getUploadtime());  
		 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 System.out.println(sd.format(date));
		
	}
	@Test
	public void testDelete(){
		String path=userAttachmentMapper.selectByPrimaryKey(13).getPath();
		if(userAttachmentMapper.deleteByPrimaryKey(13)>0){
			File file =new File(path);
			if(file.exists()){
				System.out.println(file.delete());;
			}

		};
		
	}
	

}
