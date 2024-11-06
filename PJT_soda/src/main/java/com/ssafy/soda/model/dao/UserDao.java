package com.ssafy.soda.model.dao;

import java.util.List;

import com.ssafy.soda.model.dto.User;

public interface UserDao {

	List<User> selectAll();

}
