package com.zs.pms.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;



@Controller		//这是一个控制器，去往登录页和主页
public class HelloController {
	
	@Autowired
	UserService us;
	
	@RequestMapping("/tologin.do")
	public String tologin(){
		return "login";
	}
	
	/**
	 * 
	 * @param query	登录名和密码
	 * @param code 验证码
	 * @param session	产生会话
	 * @param map	回带数据
	 * @param query 
	 * @return	返回页面
	 */
	@RequestMapping("/login.do")
	public String login( QueryUser query,String code,HttpSession session,ModelMap map ){
		
		//验证验证码，从session中取得kaptcha生成的验证码
		String ocode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//当验证码不相同时
		if(!ocode.equals(code)){
			//页面回带信息
			map.addAttribute("MSG","验证码输入有误，请重新输入");
			//回到登录页面
			return "login";
		}
		//验证码相同时，校验登录
		TUser user;
		try {
			user=us.chkLogin(query);
			session.setAttribute("CUSER", user);
			//当前日期
			session.setAttribute("TODAY",new Date());
			return "main";
				//业务异常
		} catch (AppException e) {
			// TODO Auto-generated catch block
			//页面带信息
			map.addAttribute("MSG",e.getErrMsg());
			//回到登录页面
			return "login";
		}catch(Exception e1){
			e1.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("/totop.do")
	public String toTop(){
		return "top";
	}
	
	@RequestMapping("/toleft.do")
	public String toleft(){
		return "left";
	}
	
	@RequestMapping("/toright.do")
	public String toright(){
		return "right";
	}
	
}
