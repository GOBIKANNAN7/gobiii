package com;

public class Employee {
    private int empId;
    private int password;
	public Employee(int empId, int password) {
		super();
		this.empId = empId;
		this.password = password;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
      	
}
