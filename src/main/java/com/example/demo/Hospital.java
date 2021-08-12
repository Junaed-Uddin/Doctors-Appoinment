package com.example.demo;

public class Hospital {
	private int chamberId;
	private String chamberDesc;
	private String status;
	private String location;
	
	
	public int getChamberId() {
		return chamberId;
	}
	public void setChamberId(int chamberId) {
		this.chamberId = chamberId;
	}
	public String getChamberDesc() {
		return chamberDesc;
	}
	public void setChamberDesc(String chamberDesc) {
		this.chamberDesc = chamberDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Hospital [chamberId=" + chamberId + ", chamberDesc=" + chamberDesc + ", status=" + status
				+ ", location=" + location + "]";
	}
	public Hospital(int chamberId, String chamberDesc, String status, String location) {
		super();
		this.chamberId = chamberId;
		this.chamberDesc = chamberDesc;
		this.status = status;
		this.location = location;
	}
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
}
