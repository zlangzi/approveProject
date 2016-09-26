package com.approveproject.springmvc.pojo;

public class InfoPublisherCategory {
		private Integer id;

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
			this.title = title;
		}

		public long getPublishtime() {
			return publishtime;
		}

		public void setPublishtime(long publishtime) {
			this.publishtime = publishtime;
		}

		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		@Override
		public String toString() {
			return "InfoPublisherCategory [id=" + id + ", title=" + title + ", publishtime=" + publishtime
					+ ", typeName=" + typeName + ", status=" + status + ", publisher_id=" + publisher + "]";
		}

		private String title;

	    private long publishtime;

	    private String typeName;

	    private String status;

	    private String publisher;
}
