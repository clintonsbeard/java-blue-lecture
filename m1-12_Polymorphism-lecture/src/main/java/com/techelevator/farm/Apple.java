package com.techelevator.farm;

public class Apple implements Sellable {

	@Override
	public String getName() {
		return "Francis Weatherly, Esq.: Apple At Law";
	}

	@Override
	public int getPrice() {
		return 465;
	}
	
}