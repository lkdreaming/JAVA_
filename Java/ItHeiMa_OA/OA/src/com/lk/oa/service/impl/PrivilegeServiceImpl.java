package com.lk.oa.service.impl;

import javax.annotation.Resource;

import com.lk.oa.dao.PrivilegeDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Privilege;
import com.lk.oa.service.PrivilegeService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService {

	private PrivilegeDao privilegeDao;
	@Override
	public BaseDao getBaseDao() {
		return this.getPrivilegeDao();
	}
	
	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}
	
	@Resource(name = "privilegeDao")
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	
}