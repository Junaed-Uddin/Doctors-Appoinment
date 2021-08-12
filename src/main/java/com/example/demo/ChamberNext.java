package com.example.demo;

public class ChamberNext {
	private int chamberId;
	private String chamberDescription;
	
	public int getChamberId() {
		return chamberId;
	}
	public void setChamberId(int chamberId) {
		this.chamberId = chamberId;
	}
	public String getChamberDescription() {
		return chamberDescription;
	}
	public void setChamberDescription(String chamberDescription) {
		this.chamberDescription = chamberDescription;
	}
	@Override
	public String toString() {
		return "ChamberNext [chamberId=" + chamberId + ", chamberDescription=" + chamberDescription + "]";
	}
	public ChamberNext(int chamberId, String chamberDescription) {
		super();
		this.chamberId = chamberId;
		this.chamberDescription = chamberDescription;
	}
	public ChamberNext() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
