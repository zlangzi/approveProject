package com.approveproject.springmvc.mapper;

import java.util.List;

import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserInfoVo;
import com.approveproject.springmvc.pojo.UserVo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getAllUser();
    
    User selectByUserName(String username);
    
	User selectByUserNameAndPswd(UserVo userVo);
	
	UserInfoVo getfullUserInfo(Integer id);

	List getUsersByStatus(String passed);
}