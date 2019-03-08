package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculatorInputPage {

	private WebDriver webDriver;

	public MortgageCalculatorInputPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public MortgageCalculatorInputPage enterLoanAmount(String loanAmount) {
		WebElement amountField = webDriver.findElement(By.name("loanAmount"));
		amountField.sendKeys(loanAmount);
		return this;
	}
	
	public MortgageCalculatorInputPage enterLoanTerm(String loanTerm) {
		Select termField = new Select(webDriver.findElement(By.name("loanTerm")));
		termField.selectByVisibleText(loanTerm);
		return this;
	}
	
	public MortgageCalculatorInputPage enterInterestRate(String rate) {
		WebElement amountField = webDriver.findElement(By.name("rate"));
		amountField.sendKeys(rate);
		return this;
	}
	
	public MortgageCalculatorResultPage submitForm() {
		WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));
		submitButton.click();
		return new MortgageCalculatorResultPage(webDriver);
	}
}
