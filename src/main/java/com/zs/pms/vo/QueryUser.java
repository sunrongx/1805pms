package com.zs.pms.vo;

public class QueryUser extends QueryPage {
	private String loginname;
	private String password;
	private int isenabled;
	
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//分页用属性（单写在一个类中会导致xml的parameterType的类型中无法找到两个类中的属性）
	/*protected int start;
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
	}*/
}
