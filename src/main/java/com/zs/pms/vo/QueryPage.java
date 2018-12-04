package com.zs.pms.vo;

public class QueryPage  {
	protected int start;
	protected int end;
	protected int page;
	
	public int getStart() {
		return (page-1)*5+1;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return page*5;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
