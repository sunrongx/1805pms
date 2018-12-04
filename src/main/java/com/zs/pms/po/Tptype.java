package com.zs.pms.po;

import java.io.Serializable;

public class Tptype implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6962350296175056033L;
	private int ID;
	private String TNAME;
	private int PID;
	private String REMARK;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTNAME() {
		return TNAME;
	}
	public void setTNAME(String tNAME) {
		TNAME = tNAME;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	
	
}
