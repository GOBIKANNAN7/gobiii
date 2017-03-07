package com;


public class Signup {
	
	private String UserName;
	private String dob ;
	private String phone;
	private String email;
	private String proof;
	private String gender;
	private String accountType;
	private int password;
	
	public Signup(String userName, String dob, String phone, String email, String proof, String gender,
			String accountType, int password) {
		super();
		UserName = userName;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.proof = proof;
		this.gender = gender;
		this.accountType = accountType;
		this.password = password;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
		
}
	
	
	
				
			