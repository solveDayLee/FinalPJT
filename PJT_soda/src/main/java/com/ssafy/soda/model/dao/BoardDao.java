package com.ssafy.soda.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.dto.User;

//@Mapper
public interface BoardDao {

	List<Board> selectAll();

	Board seletByNo(int no);

	void delete(int no);

	List<Board> selectSearched(SearchCondition searchCondition);

}
