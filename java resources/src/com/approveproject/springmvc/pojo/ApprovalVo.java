package com.approveproject.springmvc.pojo;

/**
 * 申报阶段查询的VO
 * @ClassName: ApprovalVo 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月14日 上午10:13:09
 */
public class ApprovalVo {
	
	/**
	 * 项目负责人的ID
	 */
	private Integer leader_id;
	/**
	 * 阶段代码
	 *0 立项申报
	 *1实施申报
	 *2验收申报
	 *3成果申报
	 *4奖励申报
	 */
	private Integer stage; 
	/**
	 * 审核状态码
	 * -1 不通过
	 * 0未审核
	 * 1审核中
	 * 2通过
	 */
	private String status;
	public Integer getLeader_id() {
		return leader_id;
	}
	public void setLeader_id(Integer leader_id) {
		this.leader_id = leader_id;
	}
	public Integer getStage() {
		return stage;
	}
	public void setStage(Integer stage) {
		this.stage = stage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
