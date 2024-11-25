package com.ssafy.soda.model.dto;

public class Comment {
	private int boardNo;
	private int pCommentNo;
	private int commentNo;
	private String userId;
	private String comment;
	private String regDate;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(int boardNo, int pCommentNo, int commentNo, String userId, String comment, String regDate) {
		super();
		this.boardNo = boardNo;
		this.pCommentNo = pCommentNo;
		this.commentNo = commentNo;
		this.userId = userId;
		this.comment = comment;
		this.regDate = regDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getpCommentNo() {
		return pCommentNo;
	}
	public void setpCommentNo(int pCommentNo) {
		this.pCommentNo = pCommentNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Comment [boardNo=" + boardNo + ", pCommentNo=" + pCommentNo + ", commentNo=" + commentNo + ", userId="
				+ userId + ", comment=" + comment + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
}
