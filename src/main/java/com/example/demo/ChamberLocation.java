package com.example.demo;

public class ChamberLocation {
	private String chamberDescr;
	private String status;
	private String chanberCountry;
	private String chamberDiv;
	private String chamberDis;
	private String chamberThana;
	private String chamberZip;
	private String chmaberRoad;
	
	public String getChamberDescr() {
		return chamberDescr;
	}
	public void setChamberDescr(String chamberDescr) {
		this.chamberDescr = chamberDescr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getChanberCountry() {
		return chanberCountry;
	}
	public void setChanberCountry(String chanberCountry) {
		this.chanberCountry = chanberCountry;
	}
	public String getChamberDiv() {
		return chamberDiv;
	}
	public void setChamberDiv(String chamberDiv) {
		this.chamberDiv = chamberDiv;
	}
	public String getChamberDis() {
		return chamberDis;
	}
	public void setChamberDis(String chamberDis) {
		this.chamberDis = chamberDis;
	}
	public String getChamberThana() {
		return chamberThana;
	}
	public void setChamberThana(String chamberThana) {
		this.chamberThana = chamberThana;
	}
	public String getChamberZip() {
		return chamberZip;
	}
	public void setChamberZip(String chamberZip) {
		this.chamberZip = chamberZip;
	}
	public String getChmaberRoad() {
		return chmaberRoad;
	}
	public void setChmaberRoad(String chmaberRoad) {
		this.chmaberRoad = chmaberRoad;
	}
	@Override
	public String toString() {
		return "ChamberLocation [chamberDescr=" + chamberDescr + ", status=" + status + ", chanberCountry="
				+ chanberCountry + ", chamberDiv=" + chamberDiv + ", chamberDis=" + chamberDis + ", chamberThana="
				+ chamberThana + ", chamberZip=" + chamberZip + ", chmaberRoad=" + chmaberRoad + "]";
	}
	public ChamberLocation(String chamberDescr, String status, String chanberCountry, String chamberDiv,
			String chamberDis, String chamberThana, String chamberZip, String chmaberRoad) {
		super();
		this.chamberDescr = chamberDescr;
		this.status = status;
		this.chanberCountry = chanberCountry;
		this.chamberDiv = chamberDiv;
		this.chamberDis = chamberDis;
		this.chamberThana = chamberThana;
		this.chamberZip = chamberZip;
		this.chmaberRoad = chmaberRoad;
	}
	public ChamberLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
