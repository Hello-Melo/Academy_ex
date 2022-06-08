package me.Hoon.dto;

public class Member {

	private String id;
	private String email;
	private String pw;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String email, String pw) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
