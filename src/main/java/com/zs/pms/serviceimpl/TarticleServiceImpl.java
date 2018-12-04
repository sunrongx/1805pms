package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.TarticleDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TarticleBean;
import com.zs.pms.vo.QueryTarticle;

@Service
//@Transactional	//该业务支持事务
public class TarticleServiceImpl {
	@Autowired
	private TarticleDao tdao;

	@Transactional(rollbackFor=Exception.class) 	//有异常就回滚
	public void deleteByIds(int[] ids)  {
		// TODO Auto-generated method stub
		tdao.deleteByIds(ids);
	}
	
	@Transactional(rollbackFor=Exception.class) 	//有异常就回滚
	public void update(TarticleBean tart) throws AppException {
		// TODO Auto-generated method stub
		tdao.update(tart);
	}
	
	public List<TarticleBean> queryByCon(QueryTarticle query) {
		// TODO Auto-generated method stub
		return tdao.queryByCon(query);
	}

	public int insert(TarticleBean tart) throws AppException {
		// TODO Auto-generated method stub
		
		return tdao.insert(tart);
	}

	public TarticleBean queryById(int id) {
		// TODO Auto-generated method stub
		
		return tdao.queryById(id);
	}

	public void delete(int id) throws AppException {
		// TODO Auto-generated method stub
		tdao.delete(id);
	}

	public List<TarticleBean> queryByPage(QueryTarticle query,int page) {
		// TODO Auto-generated method stub
		//将当前页设置到条件中
		query.setPage(page);
		//可以设置起始和截止
		return tdao.queryByPage(query);
	}

	public int queryCount(QueryTarticle query) {
		// TODO Auto-generated method stub
		//获得总条数
		int count = tdao.queryCount(query);
		//能整除时：
		if(count%5==0){
			return count/5;
		}else{	//不能整除
			return count/5+1;
		}
	}
}
