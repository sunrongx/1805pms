package com.zs.pms.po;

import java.io.Serializable;

public class Tppic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9108774124345008755L;
	private int ID;
	private int PID;
	private String PICURL;
	private int ISDEFAULT;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public String getPICURL() {
		return PICURL;
	}
	public void setPICURL(String pICURL) {
		PICURL = pICURL;
	}
	public int getISDEFAULT() {
		return ISDEFAULT;
	}
	public void setISDEFAULT(int iSDEFAULT) {
		ISDEFAULT = iSDEFAULT;
	}
	
	
}
