package com.ssafy.soda.model.dao;

import java.util.List;

import com.ssafy.soda.model.dto.User;

public interface UserDao {

	List<User> selectAll();

	void deleteUser(int id);

	User selectByNo(int id);

	void update(User user);

}
