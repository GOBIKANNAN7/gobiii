package com;

public class Address {

	private String DoorNumber;
	private String Street;
	private String Location;
	private String City;
	private String State;
	private String Country;
	private int Pincode;
	public Address(String doorNumber, String street, String location, String city, String state, String country,
			int pincode) {
		
		this.DoorNumber = doorNumber;
		this.Street = street;
		this.Location = location;
		this.City = city;
		this.State = state;
		this.Country = country;
		this.Pincode = pincode;
	}
	public String getDoorNumber() {
		return DoorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.DoorNumber = doorNumber;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		this.Street = street;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		this.Location = location;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		this.State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		this.Country = country;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		this.Pincode = pincode;
	}
	
}