package com.techelevator.farm.instructor;

public final class Cat extends FarmAnimal {

	public Cat() {
		this(false);
	}
	
	public Cat(boolean sleeping) {
		super("Cat", "MEOW", 0, sleeping);
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "The Cat is eating";
	}
	

	

}
