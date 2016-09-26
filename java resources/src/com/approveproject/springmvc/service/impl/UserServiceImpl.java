package com.approveproject.springmvc.service.impl;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.UserExpandMapper;
import com.approveproject.springmvc.mapper.UserMapper;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserInfoVo;
import com.approveproject.springmvc.pojo.UserVo;
import com.approveproject.springmvc.service.IUserService;


/**
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Inject
	private UserExpandMapper userExpandMapper;
	
	@Inject
	private UserMapper userMapper;

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	@Override
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		
		return userMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public List<User> getAllUser(Integer page, Integer pageCount) {
		// TODO Auto-generated method stub
		
		
		return userMapper.getAllUser();
	}

	@Override
	public List<User> getUserNeeded(Map<String, Object> likeCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getOneUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getOneUser(String username, String pswd) {
		// TODO Auto-generated method stub
		UserVo userVo =new UserVo();
		userVo.setUsername(username);
		userVo.setPassword(pswd);
		return userMapper.selectByUserNameAndPswd(userVo);
	}

	@Override
	public User getOneUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserName(username);
	}
	 
	@Override
	public UserInfoVo getfullUserInfo(Integer id) {
		
		
		
		return userMapper.getfullUserInfo(id);
		
	}

	@Override
	public List getUsersByStatus(String status) {
		// TODO Auto-generated method stub
		return userMapper.getUsersByStatus(status);
	}

	 
}
