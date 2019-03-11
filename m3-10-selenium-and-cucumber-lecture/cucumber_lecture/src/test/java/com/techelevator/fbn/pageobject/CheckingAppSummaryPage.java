package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckingAppSummaryPage {

	private WebDriver webDriver;

	public CheckingAppSummaryPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getFirstName() {
		return getTextOf("firstNameValue");
	}

	public String getLastName() {
		return getTextOf("lastNameValue");
	}

	public String getDateOfBirth() {
		return getTextOf("dateOfBirthValue");
	}

	public String getStateOfBirth() {
		return getTextOf("stateOfBirthValue");
	}

	public String getEmailAddress() {
		return getTextOf("emailAddressValue");
	}

	public String getPhoneNumber() {
		return getTextOf("phoneNumberValue");
	}

	public String getStreetAddress() {
		return getTextOf("streetAddressValue");
	}

	public String getApartment() {
		return getTextOf("apartmentValue");
	}

	public String getCity() {
		return getTextOf("cityValue");
	}

	public String getState() {
		return getTextOf("stateValue");
	}

	public String getZipCode() {
		return getTextOf("zipCodeValue");
	}

	public CheckingAppThankYouPage submitApplication() {
		WebElement button = webDriver.findElement(By.className("formSubmitButton"));
		button.click();
		return new CheckingAppThankYouPage(webDriver);
	}

	private String getTextOf(String elementId) {
		return webDriver.findElement(By.id(elementId)).getText();
	}
}
