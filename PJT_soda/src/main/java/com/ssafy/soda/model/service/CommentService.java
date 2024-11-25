package com.ssafy.soda.model.service;

import com.ssafy.soda.model.dto.Comment;

public interface CommentService {

	boolean writeComment(Comment comment);

	Comment getComment(int commentNo);

	boolean deleteComment(int commentNo);

	boolean updateComment(Comment comment);

}
