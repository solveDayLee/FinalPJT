package com.ssafy.soda.model.dto;

import java.time.LocalDateTime;

public class BoardReport {
	private int boardNo;
	private char reportStatus;
	private String reportReason;
	private String reportDate;
	
	private Board board;

	public BoardReport() {}

	public BoardReport(int boardNo, char reportStatus, String reportReason, String reportDate, Board board) {
		super();
		this.boardNo = boardNo;
		this.reportStatus = reportStatus;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
		this.board = board;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public char getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(char reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "BoardReport [boardNo=" + boardNo + ", reportStatus=" + reportStatus + ", reportReason=" + reportReason
				+ ", reportDate=" + reportDate + ", board=" + board + "]";
	};

	
	
}
