package com.techelevator;

public class Rectangle {
	
	/* Member Variables */
	
	private int height;
	private int width;
	
	/* Constructor has no return type and name must match class name. */
	/* If no explicit constructor is given, this as the default. */
	
	public Rectangle() {
		
	}
	
	/* Constructor Override */
	/* Once a constructor override is created, then the no-argument constructor
	 * must be explicitly created (as above)
	 */
	
	public Rectangle(int height, int width) {
		/* this.setHeight(height); - This will work, but don't do it! */
		this.height = Math.abs(height);
		this.width = Math.abs(width);
	}
	
	/* Getters/Setters */
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = Math.abs(height);
	}
	
	/* This refers to THIS class. */
	/* So this.height is the one defined as private int height at the top. */
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = Math.abs(width);
	}
	
	/* Derived Property: Calculated, not stored */
	
	public int getArea() {
		return width * height;
	}
	
	/* A method (or function) simplifies repetitive actions we perform against an object */
	/* Gives the object behavior */
	
	public boolean isLargerThan(Rectangle other) {
		if (this.getArea() > other.getArea()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* A method overload MUST have the same return type and name... */
	/* But different type and/or number of arguments. */
	
	public boolean isLargerThan(int otherHeight, int otherWidth) {
		int otherArea = otherHeight * otherWidth;
		return this.getArea() > otherArea;
	}
	
	@Override
	public boolean equals(Object obj) {
		Rectangle other = (Rectangle) obj;
		return this.height == other.getHeight() && this.width == other.getWidth();
	}
	
	@Override
	public String toString() {
		return this.width + "x" + this.height + " - " + this.getArea() + " square feet";
	}
	
}