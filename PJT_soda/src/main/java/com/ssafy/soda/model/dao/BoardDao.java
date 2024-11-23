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


	int insertBoard(Board board);

	int updateBoard(Board board);

	List<Board> selectByCategory(Board board);

}
