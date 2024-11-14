package com.ssafy.soda.model.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.BoardDao;
import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;
@Service
@Primary
public class AdminBoardServiceImpl implements AdminBoardService{

	BoardDao boardDao;
	public AdminBoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}



	@Override
	public List<Board> getBoardlist() {
		return boardDao.selectAll();
	}



	@Override
	public Board getBoard(int no) {
		return boardDao.selectByNo(no);
	}



	@Override
	public void deleteBoard(int no) {
		boardDao.delete(no);
	}



	@Override
	public List<Board> getSearchedBoardlist(SearchCondition searchCondition) {
		return boardDao.selectBoardSearched(searchCondition);
	}



	@Override
	public List<Integer> likesListCount() {
		return boardDao.allLikesCount();
	}



	@Override
	public int getLikesCount(int no) {
		return boardDao.likesCount(no);
	}



}
