package com.example.demo;

public class countrymodel {
	private int COUNTRY_ID;
	private String COUNTRY_NAME;
	public countrymodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public countrymodel(int cOUNTRY_ID, String cOUNTRY_NAME) {
		super();
		COUNTRY_ID = cOUNTRY_ID;
		COUNTRY_NAME = cOUNTRY_NAME;
	}
	public int getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(int cOUNTRY_ID) {
		COUNTRY_ID = cOUNTRY_ID;
	}
	public String getCOUNTRY_NAME() {
		return COUNTRY_NAME;
	}
	public void setCOUNTRY_NAME(String cOUNTRY_NAME) {
		COUNTRY_NAME = cOUNTRY_NAME;
	}
	@Override
	public String toString() {
		return "countrymodel [COUNTRY_ID=" + COUNTRY_ID + ", COUNTRY_NAME=" + COUNTRY_NAME + "]";
	}
	
	

}
