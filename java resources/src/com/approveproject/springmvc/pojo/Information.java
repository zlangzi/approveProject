package com.approveproject.springmvc.pojo;

import java.util.Date;

public class Information {
	
    @Override
	public String toString() {
		return "Information [id=" + id + ", title=" + title + ", publishtime=" + publishtime + ", type_id=" + type_id
				+ ", status=" + status + ", publisher_id=" + publisher_id + ", orderby=" + orderby + ", content="
				+ content + "]";
	}

	private Integer id;

    private String title;

    private long publishtime;

    private Integer type_id;

    private String status;

    private Integer publisher_id;

    private String orderby;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby == null ? null : orderby.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}