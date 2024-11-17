package com.ssafy.soda.model.dto;

public class Likes {
	private int userNo;
	private int boardNo;
	
	private User user;
	private Board board;
	
	public Likes(){};
	
    public Likes(Board board, User user) {
        this.board = board;
        this.user = user;
    }
	

	public Likes(int userNo, int boardNo, Board board, User user) {
		super();
		this.userNo = userNo;
		this.boardNo = boardNo;
		this.board = board;
		this.user = user;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Board getBoard() {
		return board;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Likes [userNo=" + userNo + ", boardNo=" + boardNo + ", board=" + board + ", user=" + user + "]";
	}
	
	
	
}
