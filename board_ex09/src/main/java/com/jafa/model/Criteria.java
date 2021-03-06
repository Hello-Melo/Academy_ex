package com.jafa.model;

public class Criteria {
	
	private String type;
	private String keyword;
	
	private int page;
	private int perPageNum;
	
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}else{
			this.page=page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String[] getTypeCollection() {
		return this.type != null ? type.split("") : new String[] {};
	}
	
	
}
