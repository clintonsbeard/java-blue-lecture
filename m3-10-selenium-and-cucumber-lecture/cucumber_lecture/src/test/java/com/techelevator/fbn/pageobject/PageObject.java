package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class PageObject {

	private WebDriver webDriver;

	public PageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	protected void enterFieldValue(String fieldId, String value) {
		WebElement field = webDriver.findElement(By.id(fieldId));
		field.sendKeys(value);
	}
	
	protected void chooseOptionFromSelect(String fieldId, String optionText) {
		Select selectField = new Select(webDriver.findElement(By.id(fieldId)));
		selectField.selectByVisibleText(optionText);
	}
}
