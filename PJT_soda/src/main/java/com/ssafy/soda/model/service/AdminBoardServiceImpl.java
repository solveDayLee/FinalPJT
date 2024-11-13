package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.BoardDao;
import com.ssafy.soda.model.dao.UserDao;
import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;
import com.ssafy.soda.model.dto.UserSearchCondition;
@Service
@Primary
public class AdminBoardServiceImpl implements AdminBoardService{

	BoardDao boardDao;
	public AdminBoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}



	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}


	@Override
	public void deleteUser(int no) {
		userDao.delete(no);
	}


	@Override
	public List<User> getSearchedUserlist(UserSearchCondition userSearchCondition) {
		return userDao.selectSearched(userSearchCondition);
	}





	@Override
	public List<Board> getBoardlist() {
		return boardDao.selectAll();
	}



	@Override
	public Board getBoard(int no) {
		return boardDao.selectByNo(no);
	}



}
