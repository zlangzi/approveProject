package com.approveproject.springmvc.service;

import java.util.List;

import org.apache.catalina.tribes.transport.RxTaskPool;

import com.approveproject.springmvc.pojo.InfoPublisherCategory;
import com.approveproject.springmvc.pojo.Information;
/**
 * 科技资讯的服务接口
 * @ClassName: IInformationService 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月8日 下午4:43:59
 */
public interface IInformationService {
	
	/**
	 * 查询所有的科技资讯
	 * @Title: queryAllInfos 
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: List<Information>
	 */
	public List<Information> getAllInfos(Integer page,Integer pageCount) throws Exception;

	/**
	 * 根据科技资讯的类型查询
	 * @Title: getInfosByType 
	 * @Description: TODO
	 * @param typeID
	 * @return
	 * @throws Exception
	 * @return: List<Information>
	 */
	public List<Information> getInfosByTypeID(Integer typeID,Integer page,Integer pageCount) throws Exception;

	/**
	 * 根据科技资讯的ID查询
	 * @Title: getInfoByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @throws Exception
	 * @return: Information
	 */
	public Information getInfoByID(Integer id) throws Exception;
	/**
	 * 将传入的Infomation对象存入数据库
	 * @Title: addInfo 
	 * @Description: TODO
	 * @param info
	 * @return 
	 * @throws Exception
	 * @return: int
	 */
	public int addInfo(Information info) throws Exception ;
	
	/**
	 * 修改资讯信息
	 * @Title: updateInfo 
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public int  updateInfo(Information info) throws Exception;
	
	/**
	 * 根据传入的ID将选中的科技资讯发布出去
	 * @Title: publishInfoByID 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public int publishInfoByID(Integer id) throws Exception;

	List<InfoPublisherCategory> getInfoCategoryByStatus(Integer status) throws Exception;

	public int delInfoByID(Integer id);

}
