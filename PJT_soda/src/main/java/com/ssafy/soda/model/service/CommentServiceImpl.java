package com.ssafy.soda.model.service;

import java.util.List;

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
	public Comment writeComment(Comment comment) {
        // insert 후 새로 생성된 댓글 정보를 바로 조회하여 반환
        if (commentDao.insert(comment)) {
            return commentDao.getCommentByNo(comment.getCommentNo());
        }
        return null;
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

	@Override
	public List<Comment> getComments(int boardNo) {
		return commentDao.selectAll(boardNo);
	}

}
