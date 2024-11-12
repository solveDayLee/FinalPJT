package com.ssafy.soda.model.dto;

import java.time.LocalDateTime;

public class Board {
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime regDate;
	private int viewCnt = 0;;
	private String category;
	private Integer userNo;  // int -> Integer (NULL 허용을 위해)
	//참조키(User) 관계 표현: userNo 외에도 User 객체를 참조하면 더 객체지향적인 설계가 됩니다.
	private User user;
	
	public Board() {
	}
	public Board(int boardNo, String title, String writer, String content, LocalDateTime regDate, int viewCnt,
			String category, int userNo, User user) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
		this.category = category;
		this.userNo = userNo;
		this.user = user;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", category=" + category + ", userNo=" + userNo
				+ ", user=" + user + "]";
	}

	
	
	
}
