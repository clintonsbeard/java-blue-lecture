package com.techelevator.farm;

public class Cat extends FarmAnimal {

	public Cat() {
		this(false);
	}
	
	public Cat(boolean sleeping) {
		super("Cat", "meow!", 0, sleeping);
	}
	
}