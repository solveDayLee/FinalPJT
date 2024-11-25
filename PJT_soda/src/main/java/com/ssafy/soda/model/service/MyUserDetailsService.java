package com.ssafy.soda.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.dto.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  // username으로 들어오는 값이 실제로는 userId
	    User user = userDao.findById(username);// findByUserName 대신 findById 사용
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with userId: " + username);
	    }
	    return new UserPrincipal(user);  // 이 부분만 수정

	}
	
}
