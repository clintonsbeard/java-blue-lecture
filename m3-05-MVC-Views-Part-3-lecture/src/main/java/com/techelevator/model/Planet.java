package com.techelevator.model;

public class Planet {

	private String name;
	private String imageName;
	private double auFromSun;
	private long numberOfMoons;
	
	public Planet() {
		
	}
	
	public Planet(String name, String imageName, double auFromSon, long numberOfMoons) {
		this.name = name;
		this.imageName = imageName;
		this.auFromSun = auFromSon;
		this.numberOfMoons = numberOfMoons;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public double getAuFromSun() {
		return auFromSun;
	}
	public void setAuFromSun(double auFromSon) {
		this.auFromSun = auFromSon;
	}
	public long getNumberOfMoons() {
		return numberOfMoons;
	}
	public void setNumberOfMoons(long numberOfMoons) {
		this.numberOfMoons = numberOfMoons;
	}
	
}
