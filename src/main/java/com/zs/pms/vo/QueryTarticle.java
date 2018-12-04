package com.zs.pms.vo;

public class QueryTarticle {
	private int id;// 文章的id
	private String title;// 文章的题目
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//分页用属性（单写在一个类中会导致xml的parameterType的类型中无法找到两个类中的属性）
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
