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
	public boolean deleteBoard(int no) {
		if (boardDao.delete(no) == 1 ) return true;
			return false; 
		}

	@Override
	public List<Board> getSearchedBoardlist(SearchCondition searchCondition) {
		return boardDao.selectBoardSearched(searchCondition);
	}


	@Override
	public List<Board> getReportBoardlist() {
		return boardDao.sellectAllReported();
		
	}


	@Override
	public List<Character> getReportStatusList() {
		return boardDao.allResportStatus();
	}



	@Override
	public Board getReportBoardByNo(int no) {
		return boardDao.sellectReportedByNo(no);
	}



	@Override
	public boolean writeBoard(Board board) {
		if( boardDao.insertBoard(board) == 1) {
			return true;
		}
		return false;
	}



	@Override
	public boolean updateBoard(Board board) {
		if( boardDao.updateBoard(board) == 1) {
			return true;
		}
		return false;
	}


	@Override
	public List<Board> getBoardlistByCatagory(Board board) {
		return boardDao.selectByCategory(board);
	}

}
