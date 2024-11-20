package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;

public interface AdminBoardService {

	boolean deleteBoard(int no);

	List<Board> getSearchedBoardlist(SearchCondition searchCondition);

	List<Board> getBoardlist();

	Board getBoard(int no);

	List<Integer> likesListCount();

	int getLikesCount(int no);

	List<Board> getReportBoardlist();

	List<Integer> reportlikesListCount();

	List<Character> getReportStatusList();

	Board getReportBoardByNo(int no);

	void writeBoard(Board board);

	void updateBoard(Board board);

}
