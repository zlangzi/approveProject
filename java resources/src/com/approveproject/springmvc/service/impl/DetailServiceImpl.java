package com.approveproject.springmvc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.approveproject.springmvc.mapper.DetailMapper;
import com.approveproject.springmvc.pojo.Detail;
import com.approveproject.springmvc.service.IDetailService;


@Service("detailService")
public class DetailServiceImpl implements IDetailService {

	@Inject
	private DetailMapper detailMapper;
	
	@Override
	public int addDetail(Detail detail) {
		// TODO Auto-generated method stub
		return detailMapper.insertSelective(detail);
	}

	@Override
	public int deleteDetailByID(int id) {
		// TODO Auto-generated method stub
		return detailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateDetailByID(Detail detail) {
		// TODO Auto-generated method stub
		return detailMapper.updateByPrimaryKeySelective(detail);
	}

	@Override
	public List<Detail> queryAllDetailsByAppID(int app_id) {
		// TODO Auto-generated method stub
		return detailMapper.queryAllDetailsByAppID(app_id);
	}

}
