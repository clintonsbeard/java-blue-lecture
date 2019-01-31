package com.techelevator.farm.instructor;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		this(false);
	}
	
	public Cow(boolean sleeping) {
		super("Cow", "moo!", 1500, sleeping);
	}

	@Override
	public String eat() {
		return "The Cow is eating";
	}

}