package com.ssafy.soda.model.dao;

import java.util.List;

import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.dto.User;

public interface UserDao {

	List<User> selectAll();

	User selectByNo(int no);

	void update(User user);

	void delete(int no);

	List<User> selectSearched(SearchCondition searchCondition);

	User login(User user);	

	int save(User user);

	User findById(String userId);


}
