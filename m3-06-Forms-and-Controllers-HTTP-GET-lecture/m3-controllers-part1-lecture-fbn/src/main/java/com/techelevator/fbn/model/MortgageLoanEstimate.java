package com.techelevator.fbn.model;


public class MortgageLoanEstimate {

	private double loanAmount;
	private int loanTermInYears;
	private double interestRate;

	public MortgageLoanEstimate(int loanAmount, int loanTermInYears, double interestRate) {
		this.loanAmount = loanAmount;
		this.loanTermInYears = loanTermInYears;
		this.interestRate = interestRate;
	}
	
	public DollarAmount getMonthlyPayment() {
		int loanTermInMonths = loanTermInYears * 12;
		double monthlyInterestRate = interestRate / 12;
		double payment = loanAmount*((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths)) / (Math.pow(1+monthlyInterestRate, loanTermInMonths) - 1));
		return new DollarAmount((int)(payment * 100));
	}
}
