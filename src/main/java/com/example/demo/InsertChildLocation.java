package com.example.demo;

public class InsertChildLocation {
	private int parentLocationId;
	private String locDescr;
	private String status;
	public int getParentLocationId() {
		return parentLocationId;
	}
	public void setParentLocationId(int parentLocationId) {
		this.parentLocationId = parentLocationId;
	}
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
		return "InsertChildLocation [parentLocationId=" + parentLocationId + ", locDescr=" + locDescr + ", status="
				+ status + "]";
	}
	public InsertChildLocation(int parentLocationId, String locDescr, String status) {
		super();
		this.parentLocationId = parentLocationId;
		this.locDescr = locDescr;
		this.status = status;
	}
	public InsertChildLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
