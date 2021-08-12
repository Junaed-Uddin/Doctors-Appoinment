package com.example.demo;

public class UpdateLocation {
	private String locDescr;
	private String status;
	public String getLocDescr() {
		return locDescr;
	}
	public void setLocDescr(String locDescr) {
		this.locDescr = locDescr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UpdateLocation [locDescr=" + locDescr + ", status=" + status + "]";
	}
	public UpdateLocation(String locDescr, String status) {
		super();
		this.locDescr = locDescr;
		this.status = status;
	}
	public UpdateLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
