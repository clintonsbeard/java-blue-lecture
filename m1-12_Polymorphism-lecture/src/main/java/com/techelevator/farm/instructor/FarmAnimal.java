package com.techelevator.farm.instructor;

public class FarmAnimal {
	private String name;
	private String sound;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	public String getName( ) {
		return name;
	}
	public String getSound( ) {
		return sound;
	}
	
}