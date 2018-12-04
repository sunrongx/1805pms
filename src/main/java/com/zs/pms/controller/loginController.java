package com.zs.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

//@Controller
public class loginController {
	
	/*@Autowired
	UserService us;
	
	@RequestMapping("login.do")
	public String login(QueryUser query,ModelMap map,HttpSession session){
		try {
			System.out.println("1");
			us.chkLogin(query);
			return "main";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
			return "login";
		}
	}*/
	
}
