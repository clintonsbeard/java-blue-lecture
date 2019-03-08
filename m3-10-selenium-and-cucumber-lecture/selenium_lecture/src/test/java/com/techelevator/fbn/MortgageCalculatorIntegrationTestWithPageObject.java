package com.techelevator.fbn;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.techelevator.fbn.pageobject.HomePage;
import com.techelevator.fbn.pageobject.MortgageCalculatorResultPage;

public class MortgageCalculatorIntegrationTestWithPageObject {

	private static WebDriver webDriver;
	private HomePage homePage;
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/m3-java-selenium-lecture/");
		homePage = new HomePage(webDriver);
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	/* Compare this test to the same test in the MortgageCalculatorIntegrationTestWithoutPageObject class.
	 * Using the Page Object pattern here makes the test much more readable. */
	public void forms_can_be_edited_and_submitted() {
		MortgageCalculatorResultPage resultPage = homePage.clickMortgageCalculatorLink()
													.enterLoanAmount("100000")
													.enterLoanTerm("15 Years")
													.enterInterestRate("4.5")
													.submitForm();

		assertEquals("$764.99", resultPage.getPaymentAmount());
	}
}
