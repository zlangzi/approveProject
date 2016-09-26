package com.approveproject.springmvc.pojo;

import java.util.Date;

public class Detail {
    private Integer id;

    private Integer application_id;

    private long approvetime;

    private String status;

    private String comments;

    private Integer approver_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Integer application_id) {
        this.application_id = application_id;
    }

    public long getApprovetime() {
        return approvetime;
    }

    public void setApprovetime(long approvetime) {
        this.approvetime = approvetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Integer getApprover_id() {
        return approver_id;
    }

    public void setApprover_id(Integer approver_id) {
        this.approver_id = approver_id;
    }

	@Override
	public String toString() {
		return "Detail [id=" + id + ", application_id=" + application_id + ", approvetime=" + approvetime + ", status="
				+ status + ", comments=" + comments + ", approver_id=" + approver_id + "]";
	}
    
}