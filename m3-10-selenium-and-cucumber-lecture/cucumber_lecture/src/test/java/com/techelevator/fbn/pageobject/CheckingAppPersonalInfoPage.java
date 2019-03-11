package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckingAppPersonalInfoPage extends PageObject {

	private WebDriver webDriver;

	public CheckingAppPersonalInfoPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver = webDriver;
	}

	public CheckingAppPersonalInfoPage enterFirstName(String firstName) {
		enterFieldValue("firstName", firstName);
		return this;
	}
	
	public CheckingAppPersonalInfoPage enterLastName(String lastName) {
		enterFieldValue("lastName", lastName);
		return this;
	}
	
	public CheckingAppPersonalInfoPage enterDateOfBirth(String dateOfBirth) {
		enterFieldValue("dateOfBirth", dateOfBirth);
		return this;
	}
	
	public CheckingAppPersonalInfoPage enterStateOfBirth(String state) {
		chooseOptionFromSelect("stateOfBirth", state);
		return this;
	}
	
	public CheckingAppPersonalInfoPage enterEmailAddress(String emailAddress) {
		enterFieldValue("emailAddress", emailAddress);
		return this;
	}
	
	public CheckingAppPersonalInfoPage enterPhoneNumber(String phoneNumber) {
		enterFieldValue("phoneNumber", phoneNumber);
		return this;
	}
	
	public CheckingAppAddressInfoPage clickNext() {
		WebElement button = webDriver.findElement(By.className("formSubmitButton"));
		button.click();
		return new CheckingAppAddressInfoPage(webDriver);
	}
}
