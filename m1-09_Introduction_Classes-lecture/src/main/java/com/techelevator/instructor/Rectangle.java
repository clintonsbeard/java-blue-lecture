package com.techelevator.instructor;

public class Rectangle {

	/*
	 * Member Variables
	 */
	private int height;
	private int width;
	
	/*
	 * Constructor
	 * Has no return type, and name must match class name
	 * If no explicit constructor is given this no-argument constructor is the default
	 */
	public Rectangle() {
		
	}
	
	/*
	 * Constructor Override
	 * Once a constructor override is created, then the no-argument constructor
	 * must be explicitly created (as above)
	 */
	public Rectangle(int height, int width) {
		this.height = Math.abs(height);
		this.width = Math.abs(width);
	}

	
	/*
	 * Getters/Setters 
	 */
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		/* this refers to THIS class.  So this.height is the one defined as private int height at the top */
		this.height = Math.abs(height);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = Math.abs(width);
	}
	
	/*
	 * A derived property is not stored, it is calculated
	 */
	public int getArea() {
		return width * height;
	}
	
	/*
	 * A method (or function) simplify repetitive actions we perform against and object
	 * Give the object behavior
	 */
	public boolean isLargerThan(Rectangle other) {
		if (this.getArea() > other.getArea()) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * A method Overload MUST have the same return type and name, 
	 * and different type and/or number of arguments
	 */
	public boolean isLargerThan(int otherHeight, int otherWidth) {
		int otherArea = otherHeight * otherWidth;
		return this.getArea() > otherArea;
	}
	
	
	/*
	 * We can override an inherited method like .equals using the SAME method signature
	 */
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
