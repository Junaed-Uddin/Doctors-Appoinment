package com.example.demo;

public class LocationDropdown {
	private int locCode;
	private String locDescr;
	
	public int getLocCode() {
		return locCode;
	}
	public void setLocCode(int locCode) {
		this.locCode = locCode;
	}
	public String getLocDescr() {
		return locDescr;
	}
	public void setLocDescr(String locDescr) {
		this.locDescr = locDescr;
	}
	@Override
	public String toString() {
		return "LocationDropdown [locCode=" + locCode + ", locDescr=" + locDescr + "]";
	}
	public LocationDropdown(int locCode, String locDescr) {
		super();
		this.locCode = locCode;
		this.locDescr = locDescr;
	}
	public LocationDropdown() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
