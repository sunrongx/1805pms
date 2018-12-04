package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

public class TarticleBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6801694725226431082L;
	/**
	 * 
	 */
	
	private int id;
	private String title;
	private String acontent;
	private String author;
	//private int channel;
	
	private TchannelBean channel;
	
	private int isremod;
	private int ishot;
	private int creator;
	private Date creatime;
	private int updator;
	private Date updatime;
	
	
	public TchannelBean getChannel() {
		return channel;
	}
	public void setChannel(TchannelBean channel) {
		this.channel = channel;
	}
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
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsremod() {
		return isremod;
	}
	public void setIsremod(int isremod) {
		this.isremod = isremod;
	}
	public int getIshot() {
		return ishot;
	}
	public void setIshot(int ishot) {
		this.ishot = ishot;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	
	
	
	
}
