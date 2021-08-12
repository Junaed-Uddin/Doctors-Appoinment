package com.example.demo;

public class UserCheck {
	private int chamberId;
	private int userType;
	
	public int getChamberId() {
		return chamberId;
	}
	public void setChamberId(int chamberId) {
		this.chamberId = chamberId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserCheck [chamberId=" + chamberId + ", userType=" + userType + "]";
	}
	public UserCheck(int chamberId, int userType) {
		super();
		this.chamberId = chamberId;
		this.userType = userType;
	}
	public UserCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
}
