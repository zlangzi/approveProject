package com.approveproject.springmvc.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.approveproject.springmvc.pojo.ChartItem;
import com.approveproject.springmvc.service.IApplicationService;

/**
 * 返回统计图表需要的数据
 * @ClassName: CharsController 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月26日 上午10:24:46
 */
@Controller
public class CharsController {
	
	@Inject
	private IApplicationService applicationService;
	
	
	@RequestMapping("StageAndNum")
	@ResponseBody
	public Map StageAndNum(){
		
		List temp=applicationService.getStageAndNum();
		List xList=new ArrayList<>();
		List yList=new ArrayList<>();
		for(int i=0;i<temp.size();i++){
			ChartItem item=	(ChartItem)temp.get(i);
			
			xList.add(item.getxRow());
			yList.add(item.getyRow());
		}
		
		Map map =new HashMap<>();
		map.put("stage", xList);
		map.put("num", yList);
		
		return map;
	}
	
	@RequestMapping("StatusAndNum")
	@ResponseBody
	public Map StatusAndNum(){
		
		List temp=applicationService.getStatusAndNum();
		List xList=new ArrayList<>();
		List yList=new ArrayList<>();
		for(int i=0;i<temp.size();i++){
			ChartItem item=	(ChartItem)temp.get(i);
			if (item.getxRow()!=3) {
				xList.add(item.getxRow());
				yList.add(item.getyRow());
			}
			
		}
		
		Map map =new HashMap<>();
		map.put("status", xList);
		map.put("num", yList);
		
		return map;
	}

}
