package com.techelevator.farm;

public final class Cat extends FarmAnimal {

	public Cat() {
		this(false);
	}
	
	public Cat(boolean sleeping) {
		super("Cat", "meow!", 0, sleeping);
	}
	
	@Override
	public String eat() {
		return "The cat has eaten your soul.";
	}
	
}