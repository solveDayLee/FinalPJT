package com.ssafy.soda.model.dao;

import java.util.List;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.dto.UserSearchCondition;

public interface BoardDao {

	List<Board> selectAll();

	Board selectByNo(int no);

	void update(User user);

	void delete(int no);

	List<User> selectSearched(UserSearchCondition userSearchCondition);

}
