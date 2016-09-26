package com.approveproject.springmvc.pojo;

import java.util.Date;

public class UserAttachment {
    private Integer id;

    private Integer person_id;

    private String path;

    private Long uploadtime;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

  

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	public Long getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Long uploadtime) {
		this.uploadtime = uploadtime;
	}
}