package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Sellable {
	
	public Chicken() {
		this(false);
	}
	
	public Chicken(boolean sleeping) {
		super("Chicken", "cluck!", 759, sleeping);
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	@Override
	public String eat() {
		return "Chicken has been eaten!";
	}
}