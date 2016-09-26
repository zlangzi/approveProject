package com.approveproject.springmvc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.UserExpandMapper;
import com.approveproject.springmvc.pojo.User;
import com.approveproject.springmvc.pojo.UserExpand;
import com.approveproject.springmvc.service.IUserExpandService;

@Service("userExpandService")
public class UserExpandService implements IUserExpandService {
	@Inject
	private UserExpandMapper userExpandMapper;
	
	@Override
	public int addUserExpand(UserExpand expand) throws Exception {
		// TODO Auto-generated method stub
		return userExpandMapper.insert(expand);
	}

	@Override
	public int updateUserExpand(UserExpand expand) throws Exception {
		// TODO Auto-generated method stub
		return userExpandMapper.updateByPrimaryKey(expand);
	}

	@Override
	public UserExpand getOne(Integer id) {
		// TODO Auto-generated method stub
		return userExpandMapper.selectByPrimaryKey(id);
	}

}
