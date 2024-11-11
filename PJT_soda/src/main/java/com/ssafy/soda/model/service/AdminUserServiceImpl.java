package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.User;

@Service
public class AdminUserServiceImpl implements AdminUserService{
	private final UserDao userDao;
	
	public AdminUserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUser() {
		
		return userDao.selectAll();
	}

	@Override
	public User detailUser(int id) {
		return userDao.selectByNo(id);
	}

	@Override
	public void removeUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public void modifyUser(User user) {
		userDao.update(user);		
	}

}
