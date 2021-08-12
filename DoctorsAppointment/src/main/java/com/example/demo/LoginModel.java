package com.example.demo;

public class LoginModel {
	private String USERID;
	private String USER_PASS;
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginModel(String uSERID, String uSER_PASS) {
		super();
		USERID = uSERID;
		USER_PASS = uSER_PASS;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getUSER_PASS() {
		return USER_PASS;
	}
	public void setUSER_PASS(String uSER_PASS) {
		USER_PASS = uSER_PASS;
	}
	@Override
	public String toString() {
		return "LoginModel [USERID=" + USERID + ", USER_PASS=" + USER_PASS + "]";
	}
	

}
