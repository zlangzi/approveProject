package com.approveproject.springmvc.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.approveproject.springmvc.pojo.Application;
import com.approveproject.springmvc.pojo.ApproveAttachment;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserAttachment;
import com.approveproject.springmvc.service.IApplicationService;
import com.approveproject.springmvc.service.IApproveAttachmentService;
import com.approveproject.springmvc.service.IUserAttachmentService;
import com.approveproject.springmvc.service.impl.ApplicationServiceImpl;
import com.approveproject.springmvc.utils.DateTimeUtils;
import com.approveproject.springmvc.utils.FileOperateUtil;
import com.approveproject.springmvc.utils.ReflectBean;
import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * 附件上传的controller
 * @ClassName: FileUploadController 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月9日 上午11:03:52
 */
@Controller("attachmentController")
public class AttachmentController {
	
	@Inject
	IUserAttachmentService userAttachmentService;
	@Inject
	IApproveAttachmentService approveAttachmentService;
	@Inject
	private IApplicationService applicationService;
	/**
	 * 先插入数据项，并返回主键，然后将文件修改名字为id.type
	 * 
	 * @Title: userAttachementUpload 
	 * @Description: TODO
	 * @param file
	 * @param request
	 * @param model
	 * @return: String
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@ResponseBody
	@RequestMapping("uploadUserAttachment")
	public String  userAttachementUpload(@RequestParam MultipartFile file, HttpServletRequest request) throws InstantiationException, IllegalAccessException{
		System.out.println("---------upload start");
		User user=(User)request.getSession().getAttribute("user");
		UserAttachment attachment=new UserAttachment();
		attachment.setPerson_id(user.getId());
		attachment.setType("user");
		request.setAttribute("type", "user");
		attachment.setUploadtime(System.currentTimeMillis());
		
		System.out.println("插入时间："+new DateTimeUtils(attachment.getUploadtime()).getDateTime());
		
		
		userAttachmentService.addAttachment(attachment);
		System.out.println("attachment:"+attachment);
		request.setAttribute("filename", attachment.getUploadtime());
		String path=saveFile(file, request);
		System.out.println("path long:"+path.length());
		//file upload success!
		if(!"".equals(path)&&path.indexOf("user")>=0){
			attachment.setPath(path);
			userAttachmentService.updateAttachment(attachment);
		}
		else {
			userAttachmentService.deleteAttachmentByID(attachment.getId());
			
			//错误处理
		
		}

	   return "success";
		
	}
	@ResponseBody
	@RequestMapping("uploadApproveAttachment")
	public String  approveAttachmentUpload(@RequestParam MultipartFile file,@RequestParam Integer application_id,@RequestParam String type, HttpServletRequest request) throws InstantiationException, IllegalAccessException{
		System.out.println(application_id+";"+type);
		
		ApproveAttachment attachment=new ApproveAttachment();
		attachment.setApplication_id(application_id);
		attachment.setType(type);
		attachment.setUploadtime(System.currentTimeMillis());
		System.out.println("插入时间："+new DateTimeUtils(attachment.getUploadtime()).getDateTime());
		approveAttachmentService.addAttachment(attachment);
		System.out.println("attachment:"+attachment);
		request.setAttribute("filename", attachment.getUploadtime());
		request.setAttribute("type", "application");
		String path=saveFile(file, request);
		System.out.println("path long:"+path.length());
		//file upload success!
		if(!"".equals(path)&&path.indexOf("application")>=0){
			attachment.setPath(path);
			approveAttachmentService.updateAttachment(attachment);
		}
		else {
			approveAttachmentService.deleteAttachmentByID(attachment.getId());
		
		//错误处理
			
		}

	   return "success";
		
	}
	
	/**
	 * 删除附件 记录+文件
	 * @Title: delAttachment 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping("attachmentDel")
	public String delAttachment(@RequestParam String type,@RequestParam Integer id,HttpServletRequest request,HttpServletResponse response) {
		//有参数
		int isRecordDeleted=-1;
		boolean isFileDeleted=false;
		String path="";
		if(!"".equals(type)&&type!=null){
			if("approve".equals(type)){
				path=approveAttachmentService.getAttachmentByID(id).getPath();
				isRecordDeleted=approveAttachmentService.deleteAttachmentByID(id);
			}
			else if("user".equals(type)){
				path=userAttachmentService.getAttachmentByID(id).getPath();
				isRecordDeleted=userAttachmentService.deleteAttachmentByID(id);
			}
			if(isRecordDeleted>0&&!"".equals(path)&&path!=null){
				isFileDeleted=delFile(path);
			}
		}else {
			//错误处理
		}
		if(isFileDeleted){
			return "success";
		}
		else {
			return "error";
		}
	}
	
	
	@RequestMapping("attachmentDownload_app")
	public void fileDownload(@RequestParam Integer id,HttpServletRequest request,HttpServletResponse response)throws Exception {
		ApproveAttachment approveAttachment=approveAttachmentService.selecLastestAttByID(id);
		 String path=approveAttachment.getPath();  
		 Application application=applicationService.getOneApp(id);
		
	        String string=application.getTopic()+"_附件_"+new DateTimeUtils(approveAttachment.getUploadtime()).getDate()+".jpg";
	        String fileName=new String(string.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        
	        FileOperateUtil.downloadFileWrite(fileName,path,response);
	        return ; 
		
		
	}
	@RequestMapping("attachmentDownloadById")
	public void fileDownloadById(@RequestParam Integer id,HttpServletRequest request,HttpServletResponse response)throws Exception {
		ApproveAttachment approveAttachment=approveAttachmentService.selecOneByID(id);
		 String path=approveAttachment.getPath();  
		 Application application=applicationService.getOneApp(approveAttachment.getApplication_id());
		
	        String string=application.getTopic()+"_附件_"+new DateTimeUtils(approveAttachment.getUploadtime()).getDate()+".jpg";
	        String fileName=new String(string.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        
	        FileOperateUtil.downloadFileWrite(fileName,path,response);
	        return ; 
		
		
	}
	@ResponseBody
	@RequestMapping("getAllAttachment")
	public List<Attachment> getAllAttachment(@RequestParam Integer app_id,HttpServletRequest request){
		return approveAttachmentService.queryAllByAppID(app_id);
	}
	
	
	
	
	
	
	/**
	 * 保存传上来的文件
	 * @Title: saveAttachment 
	 * @Description: TODO
	 * @param file
	 * @return: void
	 */
	private String saveFile(MultipartFile file,HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("开始存文件");
		String  finalpath="";
		String path="";
		if("user".equals(request.getAttribute("type"))){
			path=request.getServletContext().getRealPath("/WEB-INF/attachment/user");
		}else{
			path=request.getServletContext().getRealPath("/WEB-INF/attachment/application");
		}
          
        System.out.println(file.getOriginalFilename());
        String fileName =request.getAttribute("filename")+"."+file.getOriginalFilename().split("\\.")[1];
        System.out.println(fileName);
        File targetFile = new File(path, fileName);  
        finalpath=path+"/"+fileName;
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();
            System.err.println("文件上传时出错");
            finalpath="";
        }  
        System.out.println("文件存储路径:"+finalpath);
        return finalpath;
	}

	/**
	 * 删除文件，成功返回true,否则为false
	 * @Title: delFile 
	 * @Description: TODO
	 * @return
	 * @return: boolean
	 * @throws FileNotFoundException 
	 */
	private boolean delFile(String  path)  {
		boolean flag=false;
		File file =new File(path);
		if(file.exists()){
			flag=file.delete();
		}
		else{
			//异常处理
		}
		
		return flag;
	}
	
	
	
	
	
}
