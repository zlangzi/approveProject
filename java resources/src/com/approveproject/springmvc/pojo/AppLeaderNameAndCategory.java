package com.approveproject.springmvc.pojo;

public class AppLeaderNameAndCategory {
	private Integer id;
	private String topic;
	private String leaderName;
	private Long createtime;
	private String description;
	private String category;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "AppLeaderNameAndCategory [id=" + id + ", topic=" + topic + ", leaderName=" + leaderName
				+ ", createtime=" + createtime + ", description=" + description + ", category=" + category + ", status="
				+ status + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
