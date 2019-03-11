package com.techelevator.fbn.model;

import java.time.LocalDate;

public class CheckingAccountApplication {
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String stateOfBirth;
	private String emailAddress;
	private String phoneNumber;
	private String addressStreet;
	private String addressApartment;
	private String addressCity;
	private String addressState;
	private String addressZip;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth2) {
		this.dateOfBirth = dateOfBirth2;
	}
	public String getStateOfBirth() {
		return stateOfBirth;
	}
	public void setStateOfBirth(String stateOfBirth) {
		this.stateOfBirth = stateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressApartment() {
		return addressApartment;
	}
	public void setAddressApartment(String addressApartment) {
		this.addressApartment = addressApartment;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
}
