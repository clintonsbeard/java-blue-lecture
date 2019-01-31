package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private int price;
	private boolean sleeping;

	public FarmAnimal(String name, String sound, int price, boolean sleeping) {
		this.name = name;
		this.sound = sound;
		this.price = price;
		this.sleeping = sleeping;
	}
	
	public abstract String eat();
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public final String getSound() {
		if (sleeping) {
			return "Zzz...";
		}
		return sound;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean isSleeping() {
		return sleeping;
	}
	
	public void sleep() {
		sleeping = true;
	}
	
	public void wake() {
		sleeping = false;
	}
}