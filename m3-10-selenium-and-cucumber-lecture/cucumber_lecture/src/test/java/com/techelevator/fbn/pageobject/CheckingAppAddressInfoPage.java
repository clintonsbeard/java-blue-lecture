package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckingAppAddressInfoPage extends PageObject {

	private WebDriver webDriver;

	public CheckingAppAddressInfoPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver = webDriver;
	}

	public CheckingAppAddressInfoPage enterStreetAddress(String streetAddress) {
		enterFieldValue("streetAddress", streetAddress);
		return this;
	}
	
	public CheckingAppAddressInfoPage enterApartment(String apartment) {
		enterFieldValue("apartmentNumber", apartment);
		return this;
	}

	public CheckingAppAddressInfoPage enterCity(String city) {
		enterFieldValue("city", city);
		return this;
	}

	public CheckingAppAddressInfoPage enterState(String state) {
		chooseOptionFromSelect("state", state);
		return this;
	}
	
	public CheckingAppAddressInfoPage enterZipCode(String zipCode) {
		chooseOptionFromSelect("zipCode", zipCode);
		return this;
	} 
	
	public CheckingAppSummaryPage clickNext() {
		WebElement button = webDriver.findElement(By.className("formSubmitButton"));
		button.click();
		return new CheckingAppSummaryPage(webDriver);
	}
}
