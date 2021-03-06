package com.hoon.model;

public class PageMaker {

	private Criteria criteria;
	private int startPage;
	private int endPage;
	private int totalCount;
	private boolean perv;
	private boolean next;
	private int displayPageNum = 10;

	public PageMaker(Criteria criteria, int totalCount) {
		this.criteria = criteria;

		endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);

		startPage = endPage - displayPageNum + 1;
		if (startPage <= 0)
			startPage = 1;

		int tempEndPage = (int) Math.ceil(totalCount / (double) criteria.getPerPageNum());
		if (endPage > tempEndPage)
			endPage = tempEndPage;

		perv = startPage != 1;
		next = endPage < tempEndPage;

	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isPerv() {
		return perv;
	}

	public void setPerv(boolean perv) {
		this.perv = perv;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

}
