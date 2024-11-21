package com.ssafy.soda.model.dao;

import java.util.List;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;

public interface BoardDao {

	List<Board> selectAll();

	Board selectByNo(int no);

	int delete(int no);

	List<Board> selectBoardSearched(SearchCondition searchCondition);

	List<Board> sellectAllReported();

	List<Character> allResportStatus();

	Board sellectReportedByNo(int no);

<<<<<<< HEAD
	void insertBoard(Board board);

	void updateBoard(Board board);

	
=======
	int create(Board board);

	int update(Board board);

	List<Board> selectByCategory(Board board);
>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52


}
