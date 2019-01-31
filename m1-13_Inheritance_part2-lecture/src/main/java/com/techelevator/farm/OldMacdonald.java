package com.techelevator.farm;

public class OldMacdonald {
	
	public static void main(String[] args) {
		
		FarmAnimal cow = new Cow();
		cow.eat();
		
		Singable[] thingsThatCanSing = new Singable[] {
			new Cow(true), new Chicken(), new Sheep(), new Tractor(), new Cat() };
		
		for(Singable singer : thingsThatCanSing) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
		}
		
		System.out.println("\n----------------------------------------------------------------\n");
		
		Sellable[] thingsToSell = new Sellable[] { new Cow(), new Chicken(), new Tractor(), new Apple() };
		
		for (Sellable item : thingsToSell) {
			System.out.println("The " + item.getName() + " costs $" + item.getPrice() + ".");
		}
		
		Chicken chicken = new Chicken();
		FarmAnimal chickenAsFarmAnimal = chicken;
		Sellable chickenAsSellable = chicken;
		Singable chickenAsSingable = chicken;
		Chicken chickenTwo = (Chicken) chickenAsSingable;
		
		System.out.println(chicken instanceof Singable);
		
		chicken.layEgg();
		
		Sheep sheep = new Sheep();
		
		System.out.println(sheep instanceof Sellable);
	}
	
}