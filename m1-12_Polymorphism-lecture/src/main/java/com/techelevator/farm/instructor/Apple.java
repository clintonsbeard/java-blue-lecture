package com.techelevator.farm.instructor;

public class Apple implements Sellable {

	@Override
	public String getName() {
		return "Apple";
	}
	
	@Override
	public int getPrice() {
		return 1;
	}
	
}
