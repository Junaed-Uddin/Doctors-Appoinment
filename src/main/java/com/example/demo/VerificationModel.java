package com.example.demo;

public class VerificationModel {
	private String EMAIL_ID;
	private String EMAIL_VERY_CODE;
	public VerificationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VerificationModel(String eMAIL_ID, String eMAIL_VERY_CODE) {
		super();
		EMAIL_ID = eMAIL_ID;
		EMAIL_VERY_CODE = eMAIL_VERY_CODE;
	}
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getEMAIL_VERY_CODE() {
		return EMAIL_VERY_CODE;
	}
	public void setEMAIL_VERY_CODE(String eMAIL_VERY_CODE) {
		EMAIL_VERY_CODE = eMAIL_VERY_CODE;
	}
	@Override
	public String toString() {
		return "VerificationModel [EMAIL_ID=" + EMAIL_ID + ", EMAIL_VERY_CODE=" + EMAIL_VERY_CODE + "]";
	}
	

}
