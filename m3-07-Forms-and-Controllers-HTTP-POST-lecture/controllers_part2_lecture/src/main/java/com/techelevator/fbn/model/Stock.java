package com.techelevator.fbn.model;

public class Stock {
	private String name; 
	private String ticker;
	private DollarAmount price;
	private float change;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public DollarAmount getPrice() {
		return price;
	}
	public void setPrice(DollarAmount price) {
		this.price = price;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
}
