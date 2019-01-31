package com.techelevator.farm;

public class Sheep extends FarmAnimal {

	public Sheep() {
		this(false);
	}
	
	public Sheep(boolean sleeping) {
		super("Sheep", "baa!", 80490, sleeping);
	}
	
	@Override
	public String eat() {
		return "Sheep starves to death because he's a little jerk.";
	}
}