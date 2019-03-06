package com.techelevator.fbn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.fbn.model.MortgageLoanEstimate;

@Controller
public class PaymentCalculatorController {

	@RequestMapping("/mortgageCalculatorInput")
	public String showMortgagePaymentCalculatorInputPage() {
		return "mortgageCalculatorInput";
	}
	
	@RequestMapping("/mortgageCalculatorResult")
	public String showMortgagePaymentCalculatorResults(@RequestParam int loanAmount,
													  @RequestParam int loanTerm,
													  @RequestParam("rate") double interestRate,
													  ModelMap model) {
		
		MortgageLoanEstimate estimate = new MortgageLoanEstimate(loanAmount, loanTerm, interestRate/100);
		model.put("estimate", estimate);
		return "mortgageCalculatorResult";
	}
}











