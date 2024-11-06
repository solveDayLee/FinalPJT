package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.User;

public interface AdminUserService {

	public List<User> getAllUser();

	public void detailUser(int id);

	public void removeUser(int id);
	

}
