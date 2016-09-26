package com.approveproject.springmvc.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.approveproject.springmvc.pojo.User;

/***
 * 拦截器登录验证
 * 
 * @ClassName: LoginIntercepter
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午3:18:09
 */
public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
//		// 获取请求的url
		String url = request.getRequestURI();
		System.out.println(url+"--------------url");
//		// 陆提交的地址
//		if (url.indexOf("login.action") >= 0 || url.indexOf("register.action") >= 0) {
//			// 如果进行登陆提交，放行
//			return true;
//		}
//		// 判断session
//		HttpSession session = request.getSession();
//		// 从session中取出用户身份信息
//		User user= (User) session.getAttribute("user");
//		System.out.println("当前访问用户:"+user);
//		if (user != null) {
//			return true;
//		}
//		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//
//		
		return true;

	}

}
