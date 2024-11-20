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
		boardDao.delete(no);
		return false;
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



	@Override
	public List<Board> getReportBoardlist() {
		return boardDao.sellectAllReported();
		
	}



	@Override
	public List<Integer> reportlikesListCount() {
		return boardDao.allReportLikesCount();
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
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
		
	}



	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}



}
