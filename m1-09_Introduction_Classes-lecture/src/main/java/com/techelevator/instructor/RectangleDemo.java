package com.techelevator.instructor;

public class RectangleDemo {

	public static void main(String[] args) {

		Rectangle rect = new Rectangle();
		rect.setHeight(-10);
		rect.setWidth(20);
		
		System.out.println( rect.getHeight() + " " + rect.getWidth() + " " + rect.getArea());

		Rectangle rectTwo = new Rectangle();
		rectTwo.setHeight(18);
		rectTwo.setWidth(12);
		System.out.println(  rect.isLargerThan(rectTwo)  );
		
		System.out.println(  rect.isLargerThan(5, 10));

		Rectangle rectThree = new Rectangle(10, 20);
		
		System.out.println( rect.equals(rectThree) );
		
		System.out.println(rect);
		
		
		
	}

}
