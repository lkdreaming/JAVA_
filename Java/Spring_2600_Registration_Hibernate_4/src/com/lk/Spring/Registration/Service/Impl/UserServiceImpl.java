package com.lk.Spring.Registration.Service.Impl;


import com.lk.Spring.Registration.Service.UserService;
import com.lk.Spring.Registration.dao.UserDao;
import com.lk.Spring.Registration.dao.impl.UserDaoImpl;
import com.lk.Spring.Registration.model.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	
	public void add(User u) {
		userDao.save(u);
	}

	public boolean userExists(User u) {
		return userDao.userExists(u);
	}
	
}