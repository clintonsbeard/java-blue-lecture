package com.techelevator.farm.instructor;

public class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private int price;
	
	public FarmAnimal(String name, String sound, int price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}
	
	@Override
	public String getName( ) {
		return name;
	}
	
	@Override
	public String getSound( ) {
		return sound;
	}
	
	public int getPrice() {
		return price;
	}
	
}