package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.dto.UserSearchCondition;

public interface AdminBoardService {

	void updateUser(User user);

	void deleteUser(int no);

	List<User> getSearchedUserlist(UserSearchCondition userSearchCondition);

	List<Board> getBoardlist();

	Board getBoard(int no);

}
