package com.techelevator.farm;

public class Sheep extends FarmAnimal {

	public Sheep() {
		this(false);
	}
	
	public Sheep(boolean sleeping) {
		super("Sheep", "baa!", 80490, sleeping);
	}
	
}