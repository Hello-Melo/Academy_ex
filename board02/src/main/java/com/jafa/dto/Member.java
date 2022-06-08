package com.jafa.dto;

public class Member {

	private String userId;
	private String email;
	private String pw;

	public Member() {
	}

	public Member(String userId, String email, String pw) {
		super();
		this.userId = userId;
		this.email = email;
		this.pw = pw;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", email=" + email + ", pw=" + pw + "]";
	}

}
