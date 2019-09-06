package com.yi.domain;

public class Member {
	private String userid;
	private String userpw;
	private String username;
	private String email;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String userid, String userpw, String username, String email) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", email=" + email + "]";
	}
	
	
	
}
