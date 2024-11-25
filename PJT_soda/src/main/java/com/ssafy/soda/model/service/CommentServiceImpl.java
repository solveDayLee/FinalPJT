package com.ssafy.soda.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.CommentDao;
import com.ssafy.soda.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentDao commentDao;
	
	public CommentServiceImpl(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}

	@Override
	public boolean writeComment(Comment comment) {
		return commentDao.insert(comment);
	}

	@Override
	public Comment getComment(int commentNo) {
		return commentDao.getCommentByNo(commentNo);
	}

	@Override
	public boolean deleteComment(int commentNo) {
		return commentDao.delete(commentNo);
	}

	@Override
	public boolean updateComment(Comment comment) {
		return commentDao.update(comment);
	}

}
