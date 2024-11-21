package com.ssafy.soda.model.dto;

public class Board {
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt;
	private String category;
<<<<<<< HEAD
	private String detailCategory;
	private Integer userNo;
=======
	private Integer userNo;
	
	// -- 보드와 likes 개수 같이 나오게 하기 실험
	private int likesCnt;
>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52

	///// --- 유저와 보드 연결 소운 실험 코드------------
	private User user;
//	private Likes likes;
	private BoardReport boardReport;

	private String detailCategory;
	
	
	public BoardReport getBoardReport() {
		return boardReport;
	}

	
<<<<<<< HEAD
	public Likes getLikes() {
			return likes;
	}
=======
//	public Likes getLikes() {
//		return likes;
//	}
>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52
	
	public Board(User user) {
		this.user = user;
	}

//	public Board(User user, Likes likes) {
//		this.user = user;
//		this.likes = likes;
//	}
	
	
	// -- 보드와 likes 개수 같이 나오게 하기 실험
	public int getLikesCnt() {
		return likesCnt;
	}
	public void setLikesCnt(int likesCnt) {
		this.likesCnt = likesCnt;
	}
	

	public User getUser() {
<<<<<<< HEAD
			return user;
=======
		return user;
>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52
	}

	// 유저 번호를 불러올 수 있도록 함.
	public Integer getUserNo() {
<<<<<<< HEAD
		// 유저가 삭제된 경우 null 이 뜰 수도 있음
			return userNo;
=======
		// 유저가 삭제된 경우 null 이 뜰 수도 있음 -> 아님. myBatis 가 0으로 바꿔줌. 
		return userNo;
>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52
	}

	// 유저 아이디 가져오기
	public String getUserId() {
		// 유저가 삭제된 경우 null 이 뜰 수도 있음
		if (user != null) {
			return user.getUserId();
		} else {
			return null;
		}
	}
	///////////////////////////////////////////////

	public Board() {
	}


<<<<<<< HEAD
	public Board(int boardNo, String title, String writer, String content, String regDate, int viewCnt, String category,
			String detailCategory, Integer userNo, User user, Likes likes, BoardReport boardReport) {
=======
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


	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setBoardReport(BoardReport boardReport) {
		this.boardReport = boardReport;
	}
	

	public String getDetailCategory() {
		return detailCategory;
	}


	public void setDetailCategory(String detailCategory) {
		this.detailCategory = detailCategory;
	}


	public Board(int boardNo, String title, String writer, String content, String regDate, int viewCnt, String category,
			Integer userNo, int likesCnt, User user, BoardReport boardReport, String detailCategory) {
>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52
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
<<<<<<< HEAD
		this.likes = likes;
		this.boardReport = boardReport;
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


	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setLikes(Likes likes) {
		this.likes = likes;
	}
=======
		this.boardReport = boardReport;
		this.detailCategory = detailCategory;
	}

>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52


	public void setBoardReport(BoardReport boardReport) {
		this.boardReport = boardReport;
	}


	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", content=" + content
<<<<<<< HEAD
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", category=" + category + ", detailCategory="
				+ detailCategory + ", userNo=" + userNo + ", user=" + user + ", likes=" + likes + ", boardReport="
				+ boardReport + "]";
	}
=======
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", category=" + category + ", userNo=" + userNo
				+ ", likesCnt=" + likesCnt + ", user=" + user + ", boardReport=" + boardReport + ", detailCategory="
				+ detailCategory + "]";
	}


>>>>>>> ef5a32448034bafba9068181eaa8548a451e0d52
	
	

}