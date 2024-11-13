package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dao.BoardDao;
import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;

public class AdminBoardServiceImpl implements AdminBoardService{

	private BoardDao boardDao;
	
	
	
	public AdminBoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getAllBoard() {
		return boardDao.selectAll();
	}

	@Override
	public User detailBoard(int no) {
		return boardDao.seletByNo(no);
	}

	@Override
	public void removeBoard(int no) {
		boardDao.delete(no);
	}


}
