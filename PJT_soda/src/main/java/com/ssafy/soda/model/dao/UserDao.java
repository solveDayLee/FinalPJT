package com.ssafy.soda.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.soda.model.dto.SearchCondition;
import com.ssafy.soda.model.dto.User;

//@Mapper
public interface UserDao {

	public List<User> selectAllUser();

	public void deleteUser(int no);

	public User selectByNo(int no);

	public void update(User user);

	public List<User> selectSearched(SearchCondition searchCondition);


}
