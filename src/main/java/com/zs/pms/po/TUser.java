package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zs.pms.utils.DateUtil;





public class TUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1075410197256304212L;
	private int id;
	private String loginname;
	private String password;
	private String sex;
	private Date birthday;
	
	private String birthdayTxt;
	
	public String getBirthdayTxt() {
		return DateUtil.getStrDate(birthday);
	}

	public void setBirthdayTxt(String birthdayTxt) {
		this.birthdayTxt = birthdayTxt;
	}
	private String email;
	
	private TDep dept; //一对一关联对象
	
	private String realname;
	private int creator;
	private Date creatime;
	private int updator;
	private Date updatime;
	private String picurl;
	private int isenabled;
	
	private String isenabledTxt;
	
	public String getIsenabledTxt() {
		if(isenabled==1){
			return "可用";
		}else{
			return "不可用";
		}
		
	}

	

	public void setIsenabledTxt(String isenabledTxt) {
		this.isenabledTxt = isenabledTxt;
	}

	
	private List<TPermission> permissions;
	
	//左侧菜单，由tpermission整理出来
	private List<TPermission> menu = new ArrayList<>();
	
	/**
	 * 整理菜单
	 */
	public List<TPermission> getMenu(){
		//在刷新页面后先清空菜单
		menu.clear();
		for(TPermission per1 : permissions){
			//一级菜单
			if(per1.getPid()==0){
				//清空二级菜单
				per1.getChildren().clear();
				//装载一级菜单下的二级菜单
				for(TPermission per2 : permissions){
					//一级菜单的id等于二级菜单的pid
					//说明该权限是一级菜单的子权限
					if(per1.getId()==per2.getPid()){
						per1.getChildren().add(per2);
					}
				}
				//将装载好的一级菜单装入菜单中
				menu.add(per1);
				
			}
		}
		return menu;
	}
	
	
	
	
	
	public List<TPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<TPermission> permissions) {
		this.permissions = permissions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public TDep getDept() {
		return dept;
	}
	public void setDept(TDep dept) {
		this.dept = dept;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
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
	
	public void setMenu(List<TPermission> menu) {
		this.menu = menu;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	
	
	

}
