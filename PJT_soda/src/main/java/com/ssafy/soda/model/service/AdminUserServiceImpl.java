package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.User;

public class AdminUserServiceImpl implements AdminUserService{

	UserDao userDao;
	public AdminUserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public List<User> getUserlist() {
		return userDao.selectAll();
	}

}
