package com.ssafy.soda.model.dto;

import java.time.LocalDate;

public class User {
	private int userNo;
	private String userId;
	private String userNickname;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;
	private String birthDate;
	private String gender;
	private String address;
	private String detailAddress;
	private String zonecode;
	private String userRegDate;
	private String role;
	//토큰 추가
	private String token;
	
	public User() {
	}

	public User(int userNo, String userId, String userNickname, String password, String name, String email,
			String phoneNumber, String birthDate, String gender, String address, String detailAddress, String zonecode,
			String userRegDate, String role, String token) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userNickname = userNickname;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.detailAddress = detailAddress;
		this.zonecode = zonecode;
		this.userRegDate = userRegDate;
		this.role = role;
		this.token = token;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userNickname=" + userNickname + ", password="
				+ password + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", birthDate="
				+ birthDate + ", gender=" + gender + ", address=" + address + ", detailAddress=" + detailAddress
				+ ", zonecode=" + zonecode + ", userRegDate=" + userRegDate + ", role=" + role + ", token=" + token
				+ "]";
	}


	

	

}