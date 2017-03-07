package com;

public class User {
    private String userName;
    private int accountNumber,password;
      
	public User(String userName, int accountNumber, int password) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}	
}
