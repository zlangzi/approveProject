package com.approveproject.springmvc.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 *  
 * @author geloin 
 * @date 2012-5-5 下午12:05:57 
 */  
public class FileOperateUtil {  
     
	
	public static void downloadFileWrite(String realName,String downLoadPath, HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  

        long fileLength = new File(downLoadPath).length();  
  
        response.setContentType("application/octet-stream");  
        response.setHeader("Content-disposition", "attachment; filename="  
                + realName);  
        response.setHeader("Content-Length", String.valueOf(fileLength));  
  
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.close();  
	}
}  