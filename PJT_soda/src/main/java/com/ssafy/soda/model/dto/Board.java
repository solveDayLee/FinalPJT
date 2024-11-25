package com.ssafy.soda.model.dto;

public class Board {
	private Integer boardNo;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt;
	private String category;
	private String detailCategory;
	private Integer userNo;
	private int likesCnt;
	private User user;
	private BoardReport boardReport;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
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
	public String getDetailCategory() {
		return detailCategory;
	}
	public void setDetailCategory(String detailCategory) {
		this.detailCategory = detailCategory;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public int getLikesCnt() {
		return likesCnt;
	}
	public void setLikesCnt(int likesCnt) {
		this.likesCnt = likesCnt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BoardReport getBoardReport() {
		return boardReport;
	}
	public void setBoardReport(BoardReport boardReport) {
		this.boardReport = boardReport;
	}
	public Board(int boardNo, String title, String writer, String content, String regDate, int viewCnt, String category,
			String detailCategory, Integer userNo, int likesCnt, User user, BoardReport boardReport) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
		this.category = category;
		this.detailCategory = detailCategory;
		this.userNo = userNo;
		this.likesCnt = likesCnt;
		this.user = user;
		this.boardReport = boardReport;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", category=" + category + ", detailCategory="
				+ detailCategory + ", userNo=" + userNo + ", likesCnt=" + likesCnt + ", user=" + user + ", boardReport="
				+ boardReport + "]";
	}

	

}