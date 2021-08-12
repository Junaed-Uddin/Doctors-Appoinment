package com.example.demo;

public class ChamberDetailsInsert {
	private int chamberId;
	private String address1;
	private String address2;
	private String contaactNo1;
	private String contactNo2;
	private String contactperson1;
	private String contactperson2;
	private String email;
	private String status; 
	private String chamberDescr;
	
	public int getChamberId() {
		return chamberId;
	}
	public void setChamberId(int chamberId) {
		this.chamberId = chamberId;
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
	public String getChamberDescr() {
		return chamberDescr;
	}
	public void setChamberDescr(String chamberDescr) {
		this.chamberDescr = chamberDescr;
	}
	@Override
	public String toString() {
		return "ChamberDetailsInsert [chamberId=" + chamberId + ", address1=" + address1 + ", address2=" + address2
				+ ", contaactNo1=" + contaactNo1 + ", contactNo2=" + contactNo2 + ", contactperson1=" + contactperson1
				+ ", contactperson2=" + contactperson2 + ", email=" + email + ", status=" + status + ", chamberDescr="
				+ chamberDescr + "]";
	}
	public ChamberDetailsInsert(int chamberId, String address1, String address2, String contaactNo1, String contactNo2,
			String contactperson1, String contactperson2, String email, String status, String chamberDescr) {
		super();
		this.chamberId = chamberId;
		this.address1 = address1;
		this.address2 = address2;
		this.contaactNo1 = contaactNo1;
		this.contactNo2 = contactNo2;
		this.contactperson1 = contactperson1;
		this.contactperson2 = contactperson2;
		this.email = email;
		this.status = status;
		this.chamberDescr = chamberDescr;
	}
	public ChamberDetailsInsert() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
