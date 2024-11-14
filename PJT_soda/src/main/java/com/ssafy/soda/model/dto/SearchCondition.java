package com.ssafy.soda.model.dto;

public class SearchCondition {
	private String category;
	private String keyword;
	
	public SearchCondition() {
	}
	
	public SearchCondition(String category, String keyword) {
		super();
		this.category = category;
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCondition [category=" + category + ", keyword=" + keyword + "]";
	}
	
	
	
	
	
}
