package com.approveproject.springmvc.utils;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;


public class ReflectBean {
	/**
	 * 
	 * @Title: getBean 
	 * @Description: 根据类模板cls将HttpServletRequest的参数，反射成一个Bean对象
	 * @param cls
	 * @param request
	 * @return
	 * @return: Object
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Object  getBeanFromPOST(Class cls,HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		request.setAttribute("name", "任建树");
		request.setAttribute("gender", "男");
		request.setAttribute("idcard", "111111111111111111");
		request.setAttribute("phone", "18487141234");
		request.setAttribute("email", "1148402529@qq.com");
		request.setAttribute("username", "jianren");
		request.setAttribute("password", "111");
		
		Object bean=cls.newInstance();
		
		//获得这个类的所有属性
		Field[] fields=cls.getDeclaredFields();
		//遍历属性，并根据属性名获取request传过来的参数，进行赋值
		for(int i=0;i<fields.length;i++){
			Field field=fields[i];
			//打开属性访问权限
			field.setAccessible(true);
			
			Object value=request.getAttribute(field.getName());
			
			if (value!=null&&!("".equals(value))) {
				field.set(bean, value);
			}
		}
		
		
		return bean;
	}
}
