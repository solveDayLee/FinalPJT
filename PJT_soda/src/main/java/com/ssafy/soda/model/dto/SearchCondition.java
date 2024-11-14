package com.ssafy.soda.model.dto;

//keyword랑 category
public class SearchCondition {
	private String keyword;
	private String category;
	
	public SearchCondition() {
	}

	public SearchCondition(String keyword, String category) {
		super();
		this.keyword = keyword;
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SearchCondition [keyword=" + keyword + ", category=" + category + "]";
	}

}
