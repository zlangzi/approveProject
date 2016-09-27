package com.approveproject.springmvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.ApplicationMapper;
import com.approveproject.springmvc.mapper.InformationMapper;
import com.approveproject.springmvc.pojo.InfoPublisherCategory;
import com.approveproject.springmvc.pojo.Information;
import com.approveproject.springmvc.service.IInformationService;
/**
 * 科技资讯的服务实现类
 * @ClassName: InformationServiceImpl 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月12日 上午10:00:57
 */
@Service("informationService")
public class InformationServiceImpl implements IInformationService {

	@Inject
	private InformationMapper informationMapper;
	/**
	 * @Description 
	 * @param page
	 * @param pageCount
	 * @return
	 */
	@Override
	public List<Information> getAllInfos(Integer page, Integer pageCount) throws Exception {
		// TODO Auto-generated method stub
		
		return informationMapper.getAllInfos();
	}
	
	@Override
	public List<Information> getInfosByTypeID(Integer typeID, Integer page, Integer pageCount) throws Exception {
		// TODO Auto-generated method stub
		return informationMapper.getAllInfosByTypeID(typeID);
	}

	@Override
	public Information getInfoByID(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		return informationMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addInfo(Information info) throws Exception {
		// TODO Auto-generated method stub
		return informationMapper.insertSelective(info);
	}

	@Override
	public int updateInfo(Information info) throws Exception {
		// TODO Auto-generated method stub
		return informationMapper.updateByPrimaryKeySelective(info);
	}

	@Override
	public int publishInfoByID(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InfoPublisherCategory> getInfoCategoryByStatus(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return informationMapper.getInfoCategoryByStatus(status);
	}

	@Override
	public int delInfoByID(Integer id) {
		// TODO Auto-generated method stub
		return informationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Information> getAllInfosByStatus(String status) {
		// TODO Auto-generated method stub
		return informationMapper.getAllInfosByStatus(status);
	}
	

}
