package com.example.demo;

public class PatientinsertModel {
	private String USERID;
	private String USER_PASS;
	private String EMAILID;
	private String EMAIL_VERY_CODE;
	private int USER_TYPE_ID;
	public PatientinsertModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientinsertModel(String uSERID, String uSER_PASS, String eMAILID, String eMAIL_VERY_CODE,
			int uSER_TYPE_ID) {
		super();
		USERID = uSERID;
		USER_PASS = uSER_PASS;
		EMAILID = eMAILID;
		EMAIL_VERY_CODE = eMAIL_VERY_CODE;
		USER_TYPE_ID = uSER_TYPE_ID;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getUSER_PASS() {
		return USER_PASS;
	}
	public void setUSER_PASS(String uSER_PASS) {
		USER_PASS = uSER_PASS;
	}
	public String getEMAILID() {
		return EMAILID;
	}
	public void setEMAILID(String eMAILID) {
		EMAILID = eMAILID;
	}
	public String getEMAIL_VERY_CODE() {
		return EMAIL_VERY_CODE;
	}
	public void setEMAIL_VERY_CODE(String eMAIL_VERY_CODE) {
		EMAIL_VERY_CODE = eMAIL_VERY_CODE;
	}
	public int getUSER_TYPE_ID() {
		return USER_TYPE_ID;
	}
	public void setUSER_TYPE_ID(int uSER_TYPE_ID) {
		USER_TYPE_ID = uSER_TYPE_ID;
	}
	@Override
	public String toString() {
		return "PatientinsertModel [USERID=" + USERID + ", USER_PASS=" + USER_PASS + ", EMAILID=" + EMAILID
				+ ", EMAIL_VERY_CODE=" + EMAIL_VERY_CODE + ", USER_TYPE_ID=" + USER_TYPE_ID + "]";
	}
	
}
