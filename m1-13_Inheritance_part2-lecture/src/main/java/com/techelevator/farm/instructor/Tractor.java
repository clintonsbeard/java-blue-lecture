package com.techelevator.farm.instructor;

public class Tractor implements Singable, Sellable {

	@Override
	public String getName() {
		
		return "Tractor";
	}

	@Override
	public String getSound() {
	
		return "Vrooom";
	}
	
	@Override
	public int getPrice() {
		return 2000;
	}


	
}
