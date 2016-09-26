package com.approveproject.springmvc.service;

import java.util.List;

import javax.inject.Inject;

import com.approveproject.springmvc.mapper.InfoTypeMapper;
import com.approveproject.springmvc.pojo.InfoType;

public interface IInfoTypeService {
		
	List<InfoType> getInfoTypes();
}
