package com.techelevator.farm.instructor;

public class Chicken extends FarmAnimal implements Sellable {
	
	public Chicken() {
		super("Chicken", "cluck!", 25);
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}