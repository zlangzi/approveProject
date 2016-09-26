package com.approveproject.springmvc.service;

import java.util.List;

import com.approveproject.springmvc.pojo.Role;

/**
 * 角色服务接口定义
 * 包括：角色增删查改
 * @ClassName: IRoleService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月14日 下午3:00:26
 */
public interface IRoleService {
	
	public int addRole(Role role)throws Exception ;
	
	public int delRole(Integer id)throws Exception ;
	
	public Role getRoleByID(Integer  id)throws Exception ;
	
	public List<Role> getAllRole(Integer page,Integer pageCount)throws Exception ;
	
	public int updateRoleByID(Role role)throws Exception ;
}
