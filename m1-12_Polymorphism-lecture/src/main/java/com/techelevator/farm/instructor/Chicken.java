package com.techelevator.farm.instructor;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!");
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}