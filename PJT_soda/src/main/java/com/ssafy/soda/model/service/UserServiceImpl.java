package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	AuthenticationManager authenticationManager;

	private final UserDao userDao;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserServiceImpl(UserDao userDao, AuthenticationManager authenticationManager) {
		super();
		this.userDao = userDao;
		this.authenticationManager = authenticationManager;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	 @Override
	    public boolean signup(User user) {
	        try {
	            // 아이디 중복 체크
	            if(userDao.findById(user.getUserId()) != null) {
	                return false;
	            }
	            
	            // 비밀번호 암호화 추가
	            String encodedPassword = passwordEncoder.encode(user.getPassword());
	            user.setPassword(encodedPassword);
	            
	            userDao.save(user);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
//	@Override
//	public User login(String userId, String password) {
//		//login 메서드 구현
//		User user = userDao.findById(userId);
//		if(user != null && user.getPassword().equals(password)) {
//			return user;
//		}
//		return null;
//	}

	 @Override
	 public boolean verify(User user) {
	     System.out.println("serviceImpl 도착: user: " + user);
	     try {
//	         Authentication authentication = 
	             authenticationManager.authenticate(
	                 new UsernamePasswordAuthenticationToken(
	                     user.getUserId(), 
	                     user.getPassword()
	                 )
	             );
	         System.out.println("증빙됨!");
	         return true;
	     } catch (AuthenticationException e) {
	         System.out.println("증빙 안 됨! 원인: " + e.getMessage());
	         return false;
	     }
	 }

	@Override
//	public User login(String userId, String password, Integer userNo) {
//		//login 메서드 구현
//		User user = userDao.findById(userId);
//		if(user != null && user.getPassword().equals(password)) {
//			return user;
//		}
//		return null;
	public User getUserById(String userId) {
		return userDao.findById(userId);
	}


}
