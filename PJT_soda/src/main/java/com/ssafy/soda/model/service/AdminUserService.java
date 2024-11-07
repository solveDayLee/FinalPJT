package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.User;

public interface AdminUserService {

	List<User> getUserlist();

	User getUser(String userId);

}
