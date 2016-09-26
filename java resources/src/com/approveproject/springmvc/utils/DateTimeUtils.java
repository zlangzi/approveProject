package com.approveproject.springmvc.utils;

import java.text.SimpleDateFormat;

/**
 * 
 * @ClassName: DateTimeUtils 
 * @Description: TODO时间格式控制类
 * @author: zl_user
 * @date: 2016年9月12日 上午9:10:54
 */
public class DateTimeUtils {
	private long timeMillis;
	public long getTimeMillis() {
		return timeMillis;
	}

	public void setTimeMillis(long timeMillis) {
		this.timeMillis = timeMillis;
	}

	public String getFormatedDateTime() {
		return formatedDateTime;
	}

	public void setFormatedDateTime(String formatedDateTime) {
		this.formatedDateTime = formatedDateTime;
	}
	private String formatedDateTime="";
	
	
	public DateTimeUtils(long timeMillis){
		this.timeMillis=timeMillis;
		this.formatedDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(new java.util.Date(this.timeMillis));
	}
	
	/**
	 * 返回一个YYYY-MM--DD--HH--MM--SS的 时间字符串
	 * @Title: formatDateTime 
	 * @Description: TODO
	 * @param timeMillis
	 * @return
	 * @return: String
	 */
	public String getDateTime(){
		
		return formatedDateTime;
	}
	/**
	 * 返回日期：年月日
	 * @Title: getYear 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getDate() {
		
		return formatedDateTime.split(" ")[0];
	}
	/**
	 * 返回时间：时分秒
	 * @Title: getTime 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public String getTime(){
		
		return formatedDateTime.split(" ")[1];
	}
	
}
