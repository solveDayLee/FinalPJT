package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.User;

public interface UserService {

	List<User> getUserList();

	boolean signup(User user);

	User login(String userId, String password);

}
