package com.approveproject.springmvc.pojo;

public class UserRoleAppVo {

	private	Integer id;
	private	String name;
	private	String username;
	private	String roleName;
	private	Integer attachmentID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getAttachmentID() {
		return attachmentID;
	}
	public void setAttachmentID(Integer attachmentID) {
		this.attachmentID = attachmentID;
	}
}
