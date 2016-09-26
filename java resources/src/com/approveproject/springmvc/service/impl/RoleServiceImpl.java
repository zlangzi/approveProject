package com.approveproject.springmvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.RoleMapper;
import com.approveproject.springmvc.pojo.Role;
import com.approveproject.springmvc.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Inject
	private RoleMapper roleMapper;
	@Override
	public int addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		
		
		return roleMapper.insert(role);
	}

	@Override
	public int delRole(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role getRoleByID(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> getAllRole(Integer page, Integer pageCount) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.getAllRole(page, pageCount);
	}

	@Override
	public int updateRoleByID(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(role);
	}

}
