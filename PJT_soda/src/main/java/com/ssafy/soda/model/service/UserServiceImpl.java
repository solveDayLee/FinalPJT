package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public boolean signup(User user) {
		try {
			//아이디 중복 체크
			if(userDao.findById(user.getUserId())!= null) {
				return false;
			}
			// 비밀번호 암호화 추가
			userDao.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User login(String userId, String password, Integer userNo) {
		//login 메서드 구현
		User user = userDao.findById(userId);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}
