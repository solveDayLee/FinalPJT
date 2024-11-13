package com.ssafy.soda.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.soda.model.dto.Board;
import com.ssafy.soda.model.dto.User;

//@Mapper
public interface BoardDao {

	List<Board> selectAll();

	User seletByNo(int no);

	void delete(int no);

}
