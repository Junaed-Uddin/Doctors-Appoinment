package com.example.demo;

public class LoginModel {
	private String USERID;
	private String USER_PASS;
	private int userType;
	private int chamberId;
	private int userCode;
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
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getChamberId() {
		return chamberId;
	}
	public void setChamberId(int chamberId) {
		this.chamberId = chamberId;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	@Override
	public String toString() {
		return "LoginModel [USERID=" + USERID + ", USER_PASS=" + USER_PASS + ", userType=" + userType + ", chamberId="
				+ chamberId + ", userCode=" + userCode + "]";
	}
	public LoginModel(String uSERID, String uSER_PASS, int userType, int chamberId, int userCode) {
		super();
		USERID = uSERID;
		USER_PASS = uSER_PASS;
		this.userType = userType;
		this.chamberId = chamberId;
		this.userCode = userCode;
	}
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
