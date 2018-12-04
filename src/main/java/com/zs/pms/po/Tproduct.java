package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

public class Tproduct implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6345762419883859929L;
	private int id;
	private String pname;
	private int BRAND;
	private String WEIGHT;
	private int ISNEW;
	private int ISHOT;
	private int ISRECOMMEND;
	private int PTYPE;
	private int CREATOR;
	private Date CREATIME;
	private int CHKTOR;
	private Date CHKTIME;
	private int UPDATOR;
	private Date UPDATIME;
	private int STATUS;
	private String FROMAREA;
	private String DISCRIBE;
	private String PACKLIST;
	private String FEATURES;
	private String COLORS;
	private String SIZES;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getBRAND() {
		return BRAND;
	}
	public void setBRAND(int bRAND) {
		BRAND = bRAND;
	}
	public String getWEIGHT() {
		return WEIGHT;
	}
	public void setWEIGHT(String wEIGHT) {
		WEIGHT = wEIGHT;
	}
	public int getISNEW() {
		return ISNEW;
	}
	public void setISNEW(int iSNEW) {
		ISNEW = iSNEW;
	}
	public int getISHOT() {
		return ISHOT;
	}
	public void setISHOT(int iSHOT) {
		ISHOT = iSHOT;
	}
	public int getISRECOMMEND() {
		return ISRECOMMEND;
	}
	public void setISRECOMMEND(int iSRECOMMEND) {
		ISRECOMMEND = iSRECOMMEND;
	}
	public int getPTYPE() {
		return PTYPE;
	}
	public void setPTYPE(int pTYPE) {
		PTYPE = pTYPE;
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
	public int getCHKTOR() {
		return CHKTOR;
	}
	public void setCHKTOR(int cHKTOR) {
		CHKTOR = cHKTOR;
	}
	public Date getCHKTIME() {
		return CHKTIME;
	}
	public void setCHKTIME(Date cHKTIME) {
		CHKTIME = cHKTIME;
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
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public String getFROMAREA() {
		return FROMAREA;
	}
	public void setFROMAREA(String fROMAREA) {
		FROMAREA = fROMAREA;
	}
	public String getDISCRIBE() {
		return DISCRIBE;
	}
	public void setDISCRIBE(String dISCRIBE) {
		DISCRIBE = dISCRIBE;
	}
	public String getPACKLIST() {
		return PACKLIST;
	}
	public void setPACKLIST(String pACKLIST) {
		PACKLIST = pACKLIST;
	}
	public String getFEATURES() {
		return FEATURES;
	}
	public void setFEATURES(String fEATURES) {
		FEATURES = fEATURES;
	}
	public String getCOLORS() {
		return COLORS;
	}
	public void setCOLORS(String cOLORS) {
		COLORS = cOLORS;
	}
	public String getSIZES() {
		return SIZES;
	}
	public void setSIZES(String sIZES) {
		SIZES = sIZES;
	}
	
	
	
}
