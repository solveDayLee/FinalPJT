package com.ssafy.soda.model.service;

import java.util.List;

import com.ssafy.soda.model.dto.Comment;

public interface CommentService {

	Comment writeComment(Comment comment);

	Comment getComment(int commentNo);

	boolean deleteComment(int commentNo);

	boolean updateComment(Comment comment);

	List<Comment> getComments(int boardNo);

}
