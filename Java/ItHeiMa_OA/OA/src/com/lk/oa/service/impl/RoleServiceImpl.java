package com.lk.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lk.oa.dao.RoleDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Role;
import com.lk.oa.service.RoleService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	private RoleDao roleDao;
	
	@Override
	public BaseDao getBaseDao() {
		return this.roleDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}
	
	@Resource(name = "roleDao")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
}