package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.SearchCondition;
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
	public User getUser(int no) {
		return userDao.selectByNo(no);
	}


	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}


	@Override
	public void deleteUser(int no) {
		userDao.delete(no);
	}


	@Override
	public List<User> getSearchedUserlist(SearchCondition searchCondition) {
		return userDao.selectSearched(searchCondition);
	}


	@Override
	public User userLogin(User user) {
		return userDao.login(user);
		
	}



}
