package com.approveproject.springmvc.pojo;

public class UserInfoVo extends User {
	
	private Role role;
	
	private UserExpand userExpand;

	public UserExpand getUserExpand() {
		return userExpand;
	}

	public void setUserExpand(UserExpand userExpand) {
		this.userExpand = userExpand;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserInfoVo [role=" + role + ", userExpand=" + userExpand + "]";
	}

}
