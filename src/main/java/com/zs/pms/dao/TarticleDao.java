package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TarticleBean;
import com.zs.pms.vo.QueryTarticle;

public interface TarticleDao {
	//通过条件查询
		public List<TarticleBean> queryByCon(QueryTarticle query );
		//查分页
		public List<TarticleBean> queryByPage(QueryTarticle query);
		//根据主键查询
		public TarticleBean queryById(int id);
		//批量删除
		public void deleteByIds(int [] ids);
		//修改
		public void update(TarticleBean tart);
		//新增
		public int insert(TarticleBean tart);
		//删除一条
		public void delete(int id);
		//查询总数
		public int queryCount(QueryTarticle query);
}
