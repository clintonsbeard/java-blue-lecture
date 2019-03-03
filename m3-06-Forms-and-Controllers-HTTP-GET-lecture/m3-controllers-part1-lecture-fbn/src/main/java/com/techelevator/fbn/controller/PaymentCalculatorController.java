package com.techelevator.fbn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.fbn.model.MortgageLoanEstimate;

@Controller
public class PaymentCalculatorController {

	@RequestMapping("/mortgageCalculatorInput")
	public String showMortgagePaymentCalculatorInputPage() {
		return "mortgageCalculatorInput";
	}
	
	@RequestMapping("/mortgageCalculatorResult")
	public String showMortgagePaymentCalculatorResults(HttpServletRequest request) {
		
		int loanAmount = Integer.parseInt(request.getParameter("loanAmount"));
		int loanTerm = Integer.parseInt(request.getParameter("loanTerm"));
		double interestRate = Double.parseDouble(request.getParameter("rate")) / 100;
		
		MortgageLoanEstimate estimate = new MortgageLoanEstimate(loanAmount, loanTerm, interestRate);
		request.setAttribute("estimate", estimate);
		
		return "mortgageCalculatorResult";
	}
}
