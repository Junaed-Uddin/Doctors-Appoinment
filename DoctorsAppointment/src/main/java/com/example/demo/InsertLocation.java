package com.example.demo;

public class InsertLocation {
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
		return "InsertLocation [locDescr=" + locDescr + ", status=" + status + "]";
	}
	public InsertLocation(String locDescr, String status) {
		super();
		this.locDescr = locDescr;
		this.status = status;
	}
	public InsertLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
