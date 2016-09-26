package com.approveproject.springmvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.InfoTypeMapper;
import com.approveproject.springmvc.pojo.InfoType;
import com.approveproject.springmvc.service.IInfoTypeService;

@Service("infoTypeService")
public class InfoTypeServiceImpl implements IInfoTypeService {
	
	@Inject
	private InfoTypeMapper infoTypeMapper;

	@Override
	public List<InfoType> getInfoTypes() {
		// TODO Auto-generated method stub
		return infoTypeMapper.getInfoTypes();
	}
	
	
	
	
}
