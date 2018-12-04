package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TDep;

public interface TdepService {
	//通过id查询
	public List<TDep> queryByPid(int pid);
}
