package com.ssafy.soda.model.dto;

public class Likes {
	private Board board;
	private User user;
	
	Likes(){}
	
	public Likes(Board board, User user) {
		super();
		this.board = board;
		this.user = user;
	}
	public int getBoardNo() {
		return board.getBoardNo();
	}
	
	
	public Board getBoard() {
		return board;
	}


//	public void setBoard(Board board) {
//		this.board = board;
//	}

	public User getUser() {
		return user;
	}

//	public void setUser(User user) {
//		this.user = user;
//	}

	@Override
	public String toString() {
		return "Likes [board=" + board + ", user=" + user + "]";
	}
	
	
	
	
	
}
