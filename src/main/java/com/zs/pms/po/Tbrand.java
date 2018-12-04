package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

public class Tbrand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2798011164157815909L;
	private int ID;
	private String BNAME;
	private String DISCRIBE;
	private String LOGOPIC;
	private String WEBURL;
	private int CREATOR;
	private Date CREATIME;
	private int UPDATOR;
	private Date UPDATIME;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBNAME() {
		return BNAME;
	}
	public void setBNAME(String bNAME) {
		BNAME = bNAME;
	}
	public String getDISCRIBE() {
		return DISCRIBE;
	}
	public void setDISCRIBE(String dISCRIBE) {
		DISCRIBE = dISCRIBE;
	}
	public String getLOGOPIC() {
		return LOGOPIC;
	}
	public void setLOGOPIC(String lOGOPIC) {
		LOGOPIC = lOGOPIC;
	}
	public String getWEBURL() {
		return WEBURL;
	}
	public void setWEBURL(String wEBURL) {
		WEBURL = wEBURL;
	}
	public int getCREATOR() {
		return CREATOR;
	}
	public void setCREATOR(int cREATOR) {
		CREATOR = cREATOR;
	}
	public Date getCREATIME() {
		return CREATIME;
	}
	public void setCREATIME(Date cREATIME) {
		CREATIME = cREATIME;
	}
	public int getUPDATOR() {
		return UPDATOR;
	}
	public void setUPDATOR(int uPDATOR) {
		UPDATOR = uPDATOR;
	}
	public Date getUPDATIME() {
		return UPDATIME;
	}
	public void setUPDATIME(Date uPDATIME) {
		UPDATIME = uPDATIME;
	}
	
	
}
