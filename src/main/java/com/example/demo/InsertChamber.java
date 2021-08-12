package com.example.demo;

public class InsertChamber {
	
	private int chamberId;
	private String chamberDescr;
	private String email;
	private String status;
	private String chamberCountry;
	private String chamberDiv;
	private String chamberDis;
	private String chamberThana;
	private String chamberZip;
	private String chamberRoad;
	private String contactperson1;
	private String contactperson2;
	private String address1;
	private String address2;
	private String contaactNo1;
	private String contactNo2;
	public int getChamberId() {
		return chamberId;
	}
	public void setChamberId(int chamberId) {
		this.chamberId = chamberId;
	}
	public String getChamberDescr() {
		return chamberDescr;
	}
	public void setChamberDescr(String chamberDescr) {
		this.chamberDescr = chamberDescr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getChamberCountry() {
		return chamberCountry;
	}
	public void setChamberCountry(String chamberCountry) {
		this.chamberCountry = chamberCountry;
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
	public String getChamberRoad() {
		return chamberRoad;
	}
	public void setChamberRoad(String chamberRoad) {
		this.chamberRoad = chamberRoad;
	}
	public String getContactperson1() {
		return contactperson1;
	}
	public void setContactperson1(String contactperson1) {
		this.contactperson1 = contactperson1;
	}
	public String getContactperson2() {
		return contactperson2;
	}
	public void setContactperson2(String contactperson2) {
		this.contactperson2 = contactperson2;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getContaactNo1() {
		return contaactNo1;
	}
	public void setContaactNo1(String contaactNo1) {
		this.contaactNo1 = contaactNo1;
	}
	public String getContactNo2() {
		return contactNo2;
	}
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}
	@Override
	public String toString() {
		return "InsertChamber [chamberId=" + chamberId + ", chamberDescr=" + chamberDescr + ", email=" + email
				+ ", status=" + status + ", chamberCountry=" + chamberCountry + ", chamberDiv=" + chamberDiv
				+ ", chamberDis=" + chamberDis + ", chamberThana=" + chamberThana + ", chamberZip=" + chamberZip
				+ ", chamberRoad=" + chamberRoad + ", contactperson1=" + contactperson1 + ", contactperson2="
				+ contactperson2 + ", address1=" + address1 + ", address2=" + address2 + ", contaactNo1=" + contaactNo1
				+ ", contactNo2=" + contactNo2 + "]";
	}
	public InsertChamber(int chamberId, String chamberDescr, String email, String status, String chamberCountry,
			String chamberDiv, String chamberDis, String chamberThana, String chamberZip, String chamberRoad,
			String contactperson1, String contactperson2, String address1, String address2, String contaactNo1,
			String contactNo2) {
		super();
		this.chamberId = chamberId;
		this.chamberDescr = chamberDescr;
		this.email = email;
		this.status = status;
		this.chamberCountry = chamberCountry;
		this.chamberDiv = chamberDiv;
		this.chamberDis = chamberDis;
		this.chamberThana = chamberThana;
		this.chamberZip = chamberZip;
		this.chamberRoad = chamberRoad;
		this.contactperson1 = contactperson1;
		this.contactperson2 = contactperson2;
		this.address1 = address1;
		this.address2 = address2;
		this.contaactNo1 = contaactNo1;
		this.contactNo2 = contactNo2;
	}
	public InsertChamber() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
