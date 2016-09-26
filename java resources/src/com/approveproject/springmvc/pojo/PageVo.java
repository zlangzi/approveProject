package com.approveproject.springmvc.pojo;
/**
 * 分页参数Bean
 * @ClassName: PageBean 
 * @Description: TODO
 * @author: zl_user
 * @date: 2016年9月14日 下午3:19:47
 */
public class PageVo {
	private Integer page;
	private Integer pageCount;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	

}
