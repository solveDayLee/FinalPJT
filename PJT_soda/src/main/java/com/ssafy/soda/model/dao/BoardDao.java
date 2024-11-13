package com.ssafy.soda.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.soda.model.dto.User;

//@Mapper
public interface BoardDao {

	public List<User> selectAll();

	public void deleteUser(int no);

	public User selectByNo(int no);


}
