package com.techelevator;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}	
	
	public boolean isAdult() {
		return age >= 18;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
