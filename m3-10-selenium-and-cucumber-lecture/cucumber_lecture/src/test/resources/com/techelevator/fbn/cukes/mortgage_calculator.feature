Feature: Mortgage Payment Calculator

Scenario: Calculate monthly payment
	Given I am calculating a monthly mortgage payment
	And the loan amount is $100000
	And the loan term is 15 years
	And the interest rate is 4.5%
	When I request the mortgage payment estimate
	Then the monthly payment is $764.99 
	