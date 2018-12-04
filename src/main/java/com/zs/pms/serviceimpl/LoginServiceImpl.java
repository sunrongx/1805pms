package com.zs.pms.serviceimpl;

import com.zs.pms.bean.UserBean;
import com.zs.pms.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public UserBean login() {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		user.setLoginname("liubei");
		user.setPassword("123321");
		user.setRealname("刘备");
		return user ;
	}

}
