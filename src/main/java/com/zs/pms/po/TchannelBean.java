package com.zs.pms.po;

import java.io.Serializable;

public class TchannelBean implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -9172518736174962306L;
private int id;//栏目id
private String cname;//栏目名
private int pid;//上级栏目
private int lev;//级别
private int isleaf; //是否叶子
private int sort;//顺序
private String isleafTxt;
private String pname;
private String levTxt;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getLev() {
	return lev;
}
public void setLev(int lev) {
	this.lev = lev;
}
public int getIsleaf() {
	return isleaf;
}
public void setIsleaf(int isleaf) {
	this.isleaf = isleaf;
}
public int getSort() {
	return sort;
}
public void setSort(int sort) {
	this.sort = sort;
}
public String getIsleafTxt() {
	return isleafTxt;
}
public void setIsleafTxt(String isleafTxt) {
	this.isleafTxt = isleafTxt;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getLevTxt() {
	return levTxt;
}
public void setLevTxt(String levTxt) {
	this.levTxt = levTxt;
}

}
