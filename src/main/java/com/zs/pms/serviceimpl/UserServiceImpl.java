package com.zs.pms.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhlabs.composite.AddComposite;
import com.zs.pms.dao.UserDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryPage;
import com.zs.pms.vo.QueryUser;

/**
 *  1、根据登录名和密码获得用户id
	2、根据用户id获得权限列表
 */


@Service
@Transactional	//该业务支持事务
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao udao;

	
//	@Autowired
//	private UserDao2 udao2;
	
	@Override
	public TUser chkLogin(QueryUser query) throws AppException {
		// TODO Auto-generated method stub
		
		List<TUser> list = udao.queryByCon(query);
		//当没有用户时
		if(list==null||list.size()!=1){
			System.out.println("123");
			throw new AppException(1001, "用户名或密码输入错误，请重新输入");
		}
		//返回第一条
		TUser user = list.get(0);
		return udao.queryById(user.getId());
	}

	/*@Override
	public TUser chkLogin2(QueryUser query) throws AppException {
		// TODO Auto-generated method stub
		return (TUser) udao.queryByCon(query);
	}*/

	@Override
	@Transactional(rollbackFor=Exception.class) 	//有异常就回滚
	public void deleteByIds(int[] ids)  {
		// TODO Auto-generated method stub
		udao.deleteByIds(ids);
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class) 	//有异常就回滚
	public void update(TUser user) throws AppException {
		// TODO Auto-generated method stub
		//不可用
		if(user.getIsenabled()==2){
			throw new AppException(1003, "不能修改不可用的用户！");
		}
		udao.update(user);
	}
	
	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return udao.queryByCon(query);
	}

	@Override
	@Transactional(rollbackFor=Exception.class) 
	public int insert(TUser user) throws AppException {
		// TODO Auto-generated method stub
		
		return udao.insert(user);
	}

	@Override
	public TUser queryById(int id) {
		// TODO Auto-generated method stub
		
		return udao.queryById(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class) 
	public void delete(int id) throws AppException {
		// TODO Auto-generated method stub
		udao.delete(id);
	}

	@Override
	public List<TUser> queryByPage(QueryUser query,int page) {
		// TODO Auto-generated method stub
		//将当前页设置到条件中
		query.setPage(page);
		//可以设置起始和截止
		return udao.queryByPage(query);
	}
	
	@Override
	public int queryCount(QueryUser query) {
		// TODO Auto-generated method stub
		return udao.queryCount(query);
	}
	
	
	
}
