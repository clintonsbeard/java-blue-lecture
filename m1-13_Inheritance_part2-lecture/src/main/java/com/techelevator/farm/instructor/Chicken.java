package com.techelevator.farm.instructor;

public class Chicken extends FarmAnimal implements Sellable {
	
	public Chicken() {
		this(false);
	}
	
	public Chicken(boolean sleeping) {
		super("Chicken", "cluck!", 25, sleeping);
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	@Override
	public String eat() {
		return "The Chicken is eating";
	}

}