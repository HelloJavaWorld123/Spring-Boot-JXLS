package com.jxls.test.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 移自生活馆 
 */
public class PageInfo
{

	/**
	 * 总记录数
	 */
	@JsonProperty("total")
	private Integer total;
	
	/**
	 * 是否有下一页
	 */
	@JsonProperty("has_next")
	private boolean hasNext;

	public PageInfo(){

	}

	public PageInfo(PageParameter pageParameter){
		this.setTotal(pageParameter.getTotalCount());
		this.setHasNext(pageParameter.getCurrentPage()<pageParameter.getTotalPage());
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}
