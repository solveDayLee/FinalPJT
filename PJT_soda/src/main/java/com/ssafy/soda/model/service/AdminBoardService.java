package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;

public interface AdminBoardService {

	boolean deleteBoard(int no);

	List<Board> getSearchedBoardlist(SearchCondition searchCondition);

	List<Board> getBoardlist();

	Board getBoard(int no);

	List<Board> getReportBoardlist();

	List<Character> getReportStatusList();

	Board getReportBoardByNo(int no);

	boolean writeBoard(Board board);

	boolean updateBoard(Board board);

	List<Board> getBoardlistByCatagory(Board board);

	boolean increaseViewCnt(int no);


}
