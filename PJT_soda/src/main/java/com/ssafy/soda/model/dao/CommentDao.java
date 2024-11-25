package com.ssafy.soda.model.dao;

import com.ssafy.soda.model.dto.Comment;

public interface CommentDao {

	boolean insert(Comment comment);

	Comment getCommentByNo(int commentNo);

	boolean delete(int commentNo);

	boolean update(Comment comment);



}
