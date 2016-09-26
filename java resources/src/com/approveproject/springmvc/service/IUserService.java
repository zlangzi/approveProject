package com.approveproject.springmvc.service;

import java.util.List;
import java.util.Map;

import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserInfoVo;

/**
 * 用户接口定义
 * @ClassName: IUserService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午4:46:42
 */
public interface IUserService {
	public int insertUser(User user) throws Exception;
	public void deleteUser(int uid);
	public int updateUser(User user);
	
	public List<User> getAllUser(Integer page, Integer pageCount);
	public List<User> getUserNeeded(Map<String, Object> likeCondition);
	public User getOneUser(int uid);
	public User getOneUser(String username, String pswd);
	public User getOneUser(String username);
	UserInfoVo getfullUserInfo(Integer id);
	public List getUsersByStatus(String status);
}
