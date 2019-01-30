package com.techelevator.farm.instructor;

public class Sheep extends FarmAnimal {

	public Sheep() {
		this(false);
	}
	
	public Sheep(boolean sleeping) {
		super("Sheep", "Baaa", 0, sleeping);
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "The Sheep is eating";
	}

}
