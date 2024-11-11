package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.dto.UserSearchCondition;

public interface AdminUserService {

	List<User> getUserlist();

	User getUser(int no);

	void updateUser(User user);

	void deleteUser(int no);

	List<User> getSearchedUserlist(UserSearchCondition userSearchCondition);

}
