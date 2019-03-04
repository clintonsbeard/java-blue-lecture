package com.techelevator;

public class Greeter {

	private String name;

	public Greeter(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return "Hello, "+name+"!";
	}
}
