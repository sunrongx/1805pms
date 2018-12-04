package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserService {
	//登录
	public TUser chkLogin(QueryUser query) throws AppException;
	//登录测试方式
	//public TUser chkLogin2(QueryUser query) throws AppException;
	
	//通过条件查询	测试用，将xml都换成注解：
	public List<TUser> queryByCon(QueryUser query );
	//根据主键查询
	public TUser queryById(int id);
	//批量删除
	public void deleteByIds(int [] ids);
	//修改
	public void update(TUser user) throws AppException;
	//新增
	public int insert(TUser user) throws AppException;
	//删除一条
	public void delete(int id) throws AppException;
	//查分页
	public List<TUser> queryByPage(QueryUser query,int page);
	//查询总数
	public int queryCount(QueryUser query);
		
}
