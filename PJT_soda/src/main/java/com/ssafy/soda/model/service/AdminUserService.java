package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.dto.User;

public interface AdminUserService {

	List<User> getUserlist();

	User getUser(int no);

	void updateUser(User user);

	void deleteUser(int no);

	List<User> getSearchedUserlist(SearchCondition searchCondition);

	
}
