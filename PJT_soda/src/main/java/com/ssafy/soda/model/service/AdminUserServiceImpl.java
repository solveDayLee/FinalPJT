package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.User;
@Service
@Primary
public class AdminUserServiceImpl implements AdminUserService{

	UserDao userDao;
	public AdminUserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public List<User> getUserlist() {
		return userDao.selectAll();
	}


	@Override
	public User getUser(String userId) {
		return userDao.selectById(userId);
	}


	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}


	@Override
	public void deleteUser(String id) {
		userDao.delete(id);
	}

}
