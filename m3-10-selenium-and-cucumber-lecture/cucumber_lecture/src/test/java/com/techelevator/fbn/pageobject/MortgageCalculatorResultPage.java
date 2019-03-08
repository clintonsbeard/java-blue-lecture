package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MortgageCalculatorResultPage {

	private WebDriver webDriver;
	
	public MortgageCalculatorResultPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String getPaymentAmount() {
		return webDriver.findElement(By.xpath("//table[@id=\"loanPaymentCalculationResults\"]//tr[4]/td")).getText();
	}

}
