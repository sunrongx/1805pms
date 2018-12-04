package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TarticleBean;
import com.zs.pms.vo.QueryTarticle;

public interface TarticleService {
	
	//通过条件查询
	public List<TarticleBean> queryByCon(QueryTarticle query );
	//根据主键查询
	public TarticleBean queryById(int id);
	//批量删除
	public void deleteByIds(int [] ids);
	//修改
	public void update(TarticleBean tart) throws AppException;
	//新增
	public int insert(TarticleBean tart) throws AppException;
	//删除一条
	public void delete(int id) throws AppException;
	//查分页
	public List<TarticleBean> queryByPage(QueryTarticle query,int page);
	//查询总数
	public int queryCount(QueryTarticle query);
}
