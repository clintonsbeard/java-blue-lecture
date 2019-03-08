package com.techelevator.fbn.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.fbn.pageobject.HomePage;
import com.techelevator.fbn.pageobject.MortgageCalculatorInputPage;
import com.techelevator.fbn.pageobject.MortgageCalculatorResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class MortgageCalculatorSteps {
	
	private WebDriver webDriver;
	private HomePage homePage;
	private MortgageCalculatorInputPage calculatorInputPage;
	private MortgageCalculatorResultPage calculatorResultPage;
	
	@Autowired 
	public MortgageCalculatorSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.calculatorInputPage = new MortgageCalculatorInputPage(webDriver);
		this.calculatorResultPage = new MortgageCalculatorResultPage(webDriver);
	}
	
	@Given("^I am calculating a monthly mortgage payment$")
	public void i_am_calculating_a_monthly_mortgage_payment() throws Throwable {
		webDriver.get("http://localhost:8080/m3-java-cucumber-lecture/");
		homePage.clickMortgageCalculatorLink();
	}

	@Given("^the loan amount is \\$(.*)$")
	public void the_loan_amount_is_$(String loanAmount) throws Throwable {
	    calculatorInputPage.enterLoanAmount(loanAmount);
	}

	@Given("^the loan term is (.*) years$")
	public void the_loan_term_is_years(String loanTerm) throws Throwable {
	    calculatorInputPage.enterLoanTerm(loanTerm+" Years");
	}

	@Given("^the interest rate is (.*)%$")
	public void the_interest_rate_is(String rate) throws Throwable {
	    calculatorInputPage.enterInterestRate(rate);
	}

	@When("^I request the mortgage payment estimate$")
	public void i_request_the_mortgage_payment_estimate() throws Throwable {
	    calculatorInputPage.submitForm();
	}

	@Then("^the monthly payment is (.*)$")
	public void the_monthly_payment_is_$(String expectedPaymentAmount) throws Throwable {
	    Assert.assertEquals(expectedPaymentAmount, calculatorResultPage.getPaymentAmount());
	}
}
