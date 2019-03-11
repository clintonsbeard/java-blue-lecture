package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver webDriver;

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public MortgageCalculatorInputPage clickMortgageCalculatorLink() {
		WebElement calculatorLink = webDriver.findElement(By.linkText("Mortgage Payment Calculator"));
		calculatorLink.click();
		return new MortgageCalculatorInputPage(webDriver);
	}
	
	public CheckingAppPersonalInfoPage clickCheckingAccountApplicationLink() {
		WebElement calculatorLink = webDriver.findElement(By.linkText("Open a New Account"));
		calculatorLink.click();
		return new CheckingAppPersonalInfoPage(webDriver);
	}
}
