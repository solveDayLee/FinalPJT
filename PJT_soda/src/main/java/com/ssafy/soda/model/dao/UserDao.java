package com.ssafy.soda.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.soda.model.dto.User;

@Mapper
public interface UserDao {

	public List<User> selectAll();

//	public void deleteUser(int id);
//
//	public User selectByNo(int id);
//
//	public void update(User user);

}
