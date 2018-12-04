package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.TdepDao;
import com.zs.pms.po.TDep;
import com.zs.pms.service.TdepService;

@Service
public class TdepServiceImpl implements TdepService {
	
	@Autowired
	TdepDao td;
	
	@Override
	public List<TDep> queryByPid(int pid) {
		// TODO Auto-generated method stub
		return td.queryByPid(pid);
	}

}
