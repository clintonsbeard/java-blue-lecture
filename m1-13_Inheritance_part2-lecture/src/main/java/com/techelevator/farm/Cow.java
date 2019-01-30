package com.techelevator.farm;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		this(false);
	}
	
	public Cow(boolean sleeping) {
		super("Cow", "moo!", 901463420, sleeping);
	}

}