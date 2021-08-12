package com.example.demo;

public class ShowLocation {
	private int locCode;
	private String locDescr;
	private String parentLoc;
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
	public String getParentLoc() {
		return parentLoc;
	}
	public void setParentLoc(String parentLoc) {
		this.parentLoc = parentLoc;
	}
	@Override
	public String toString() {
		return "ShowLocation [locCode=" + locCode + ", locDescr=" + locDescr + ", parentLoc=" + parentLoc + "]";
	}
	public ShowLocation(int locCode, String locDescr, String parentLoc) {
		super();
		this.locCode = locCode;
		this.locDescr = locDescr;
		this.parentLoc = parentLoc;
	}
	public ShowLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShowLocation(String locDescr) {
		super();
		this.locDescr = locDescr;
	}
	

}
