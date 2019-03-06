package com.techelevator.fbn.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.techelevator.fbn.model.MortgageLoanEstimate;

public class PaymentCalculatorControllerTest {

	@Test
	public void controller_adds_mortgage_estimate_to_model() {
		PaymentCalculatorController controller = new PaymentCalculatorController();
		ModelMap model = new ModelMap();
		controller.showMortgagePaymentCalculatorResults(100000, 30, 3.0, model);
		MortgageLoanEstimate estimate = (MortgageLoanEstimate)model.get("estimate");
		assertNotNull(estimate);
		assertEquals(100000, estimate.getLoanAmount());
		assertEquals(30, estimate.getLoanTermInYears());
		assertEquals(3.0, estimate.getInterestRate(), .01);
	}

}
