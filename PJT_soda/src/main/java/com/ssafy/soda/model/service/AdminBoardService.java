package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.dto.User;

public interface AdminBoardService {

	List<Board> getAllBoard();

	User detailBoard(int no);

	void removeBoard(int no);

	List<Board> getSearchBoardList(SearchCondition searchCondition);






}
