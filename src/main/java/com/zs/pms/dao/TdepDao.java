package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TDep;

public interface TdepDao {
	//根据上级id取部门
	public List<TDep> queryByPid(int pid);
}
