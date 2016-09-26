package com.approveproject.springmvc.pojo;

import java.util.List;

public class User {
    

	private Integer id;

    private String name;

    private String gender;

    private String idcard;

    private String phone;

    private String email;

    private String username;

    private String password;

    private Integer role_id;

//    private List<Application> applications;
    
    
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
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", idcard=" + idcard + ", phone=" + phone
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", role_id=" + role_id
				+ "]";
	}
}