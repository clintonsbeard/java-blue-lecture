package com.techelevator.farm;

public class Tractor implements Singable, Sellable {

	@Override
	public String getName() {
		return "Tractor";
	}

	@Override
	public String getSound() {
		return "plop!";
	}

	@Override
	public int getPrice() {
		return 2;
	}
	
}