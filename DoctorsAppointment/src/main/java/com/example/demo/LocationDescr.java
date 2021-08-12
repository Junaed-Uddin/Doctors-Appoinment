package com.example.demo;

public class LocationDescr {
	private String locDescr;

	public String getLocDescr() {
		return locDescr;
	}

	public void setLocDescr(String locDescr) {
		this.locDescr = locDescr;
	}

	@Override
	public String toString() {
		return "LocationDescr [locDescr=" + locDescr + "]";
	}

	public LocationDescr(String locDescr) {
		super();
		this.locDescr = locDescr;
	}

	public LocationDescr() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
