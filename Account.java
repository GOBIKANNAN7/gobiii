package com;

public class Account {

	private int accNumber,password,panNumber;
    private String accType,userName;
    double amount;
	public Account( String userName, int accNumber, int password, String accType, double amount, int panNumber) {
		super();
		this.accNumber = accNumber;
		this.password = password;
		this.panNumber = panNumber;
		this.accType = accType;
		this.userName = userName;
		this.amount = amount;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(int panNumber) {
		this.panNumber = panNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
